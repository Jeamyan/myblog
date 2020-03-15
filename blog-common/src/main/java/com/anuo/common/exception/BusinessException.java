package com.anuo.common.exception;

import com.anuo.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "全局异常")
public class BusinessException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    // 接收状态码和消息
    public BusinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }


    // 接收枚举
    public BusinessException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CodingException{" +
                "message=" + this.getMessage() +
                "code=" + code +
                '}';
    }
}
