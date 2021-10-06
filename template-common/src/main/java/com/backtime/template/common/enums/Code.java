package com.backtime.template.common.enums;

/**
 * @author backtime
 * @date 2021/10/420:51
 * @description: TODO
 */

public enum Code implements IErrorCode {
    SUCCESS(200, "Success"),
    ERROR(500, "Error"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    GATEWAY_TIME_OUT(504, "Gateway Timeout"),

    ;

    private int code;
    private String message;

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
