package com.anuo.common.handler;

import com.anuo.common.constants.ResultCodeEnum;
import com.anuo.common.exception.BusinessException;
import com.anuo.common.utils.ExceptionUtil;
import com.anuo.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 增加
// 统一异常处理类
@ControllerAdvice
@Slf4j
public class GlobalExecptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        // 回滚的代码
        return R.error();
    }

    // 捕获指定的异常
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.BAD_Sql_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(HttpMessageNotReadableException e){
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERRPR);
    }

    // 统一自定义异常！ CodingException ( 推荐所有人这么去写 )
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public R error(BusinessException e){
        // e.printStackTrace();
        // log.error(e.getMessage());
        // 创造者，尽量使用自己创造的代码！
        log.error(ExceptionUtil.getMessage(e));
        return R.error()
                .message(e.getMessage())
                .code(e.getCode());
    }

}
