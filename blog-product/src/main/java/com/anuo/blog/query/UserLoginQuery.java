package com.anuo.blog.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "登入对象")
@Data
public class UserLoginQuery {

    @ApiModelProperty(value = "登入账号")
    private String loginId;

    @ApiModelProperty(value = "登入密码")
    private String password;

    @ApiModelProperty(value = "验证码")
    private String verifyCode;

    @ApiModelProperty(value = "唯一key")
    private String uniquekey;
}
