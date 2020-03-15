package com.anuo.blog.controller.login;

import com.anuo.blog.entity.sys.User;
import com.anuo.blog.query.UserLoginQuery;
import com.anuo.blog.service.sys.IUserService;
import com.anuo.common.redis.RedisService;
import com.anuo.common.utils.MD5Generate;
import com.anuo.common.utils.VerifyCodeUtil;
import com.anuo.common.vo.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/system/user")
@Slf4j
public class LoginController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private IUserService userService;

    @Value("${sys.Timeout}")
    private String timeOut;

    @PostMapping(value="/login")
    public R login(UserLoginQuery userQuery, HttpServletResponse response) {
        if(StringUtils.isEmpty(userQuery.getLoginId()) || StringUtils.isEmpty(userQuery.getPassword())) {
            return R.error().code(1).message("参数错误");
        }
        //验证码校验
        String serviceVerifyCode = redisService.getCache(userQuery.getUniquekey(), String.class);
        if(StringUtils.isEmpty(serviceVerifyCode)) {
            return R.error().code(1).message("验证码过期，请重新获取！");
        }else {
            if(!serviceVerifyCode.equals(userQuery.getVerifyCode())) {
                return R.error().code(1).message("验证不正确！");
            }
        }
        //账号验证
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete",false)
                .eq("is_enable",true)
                .eq("password",MD5Generate.string2MD5(userQuery.getPassword()))
                .and(i ->
                    i.eq("user_code",userQuery.getLoginId())
                    .or().eq("mobile",userQuery.getLoginId())
                );
        User userDto = userService.getOne(queryWrapper);

        if(userDto == null) {
            return R.error().code(1).message("用户名或者密码不正确！");
        }else {
            //如果登录成功则将登录用户存入缓存中
            String accessToken = MD5Generate.string2MD5(userDto.getUserCode()+ System.currentTimeMillis());
            redisService.set(accessToken, userDto,Long.valueOf(timeOut));
            response.setHeader("accessToken", accessToken);
            log.info("用户{}登录",userDto.getUserCode());
            Map<String,Object> map = new HashMap<>();
            map.put("accessToken", accessToken);
            map.put("username", userDto.getUserName());
            return R.ok().data(map);
        }
    }

    /**
     * 获取图形 验证码
     * @param response
     * @return
     */
    @GetMapping(value="/getVerifyCodeImage")
    public R getVerifyCodeImage(HttpServletResponse response){
        String uniquekey = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_ALL_MIXED, 32, null);
        //设置页面不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
        log.info("生成验证码:{},key为{}",verifyCode,uniquekey);

        //将验证码放到缓存里面
        redisService.set(uniquekey, verifyCode, Long.valueOf("300"));

        //设置输出的内容的类型为JPEG图像
        response.setContentType("image/jpeg");
        response.setHeader("uniquekey", uniquekey);

        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "JPEG", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = out.toByteArray();

        // 对字节数组Base64编码
        String imgUrl = new String(Base64.encodeBase64(data));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uniquekey",uniquekey);
        map.put("image",imgUrl);
        return R.ok().data(map);
    }
    @GetMapping(value="/loginOut")
    public R loginOut(HttpServletRequest request) {
        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isEmpty(accessToken)) {
            return R.ok();
        }
        redisService.remove(accessToken);
        return R.ok();
    }

}
