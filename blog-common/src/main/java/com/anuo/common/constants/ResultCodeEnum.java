package com.anuo.common.constants;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    // 未来会存在大量的响应代码，是必然的！
    SUCCESS(true,20000,"成功"),
    UNKNOWN_REASON(false,20001,"未知错误"),
    BAD_Sql_GRAMMAR(false,20002,"sql异常"),
    JSON_PARSE_ERRPR(false,20003,"JSON 解析错误"),
    PARAM_ERROR(false,20004,"参数错误");

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
