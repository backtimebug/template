package com.backtime.template.common.response;

import com.backtime.template.common.enums.Code;
import lombok.Data;

/**
 * @author backtime
 * @date 2021/10/4 20:47
 * @description: TODO
 */
@Data
public class BaseResult<T> {

    private int code;

    private String msg;

    private T data;

    public BaseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> BaseResult<T> newSuccess() {
        return new BaseResult<>(Code.SUCCESS.getCode(), Code.SUCCESS.getMessage(), null);
    }

    public static <T> BaseResult<T> newSuccess(T data) {
        return new BaseResult<>(Code.SUCCESS.getCode(), Code.SUCCESS.getMessage(), data);
    }

    public static <T> BaseResult<T> newFailure() {
        return new BaseResult<>(Code.ERROR.getCode(), Code.ERROR.getMessage(), null);
    }

    public static <T> BaseResult<T> newFailure(int code) {
        return new BaseResult<>(code, Code.ERROR.getMessage(), null);
    }

    public static <T> BaseResult<T> newFailure(String msg) {
        return new BaseResult<>(Code.ERROR.getCode(), msg, null);
    }

    public static <T> BaseResult<T> newFailure(Code code) {
        return new BaseResult<>(code.getCode(), code.getMessage(), null);
    }

    public static <T> BaseResult<T> newFailure(int code, String msg) {
        return new BaseResult<>(code, msg, null);
    }

    public static <T> BaseResult<T> newFailure(String msg, T data) {
        return new BaseResult<>(Code.ERROR.getCode(), msg, data);
    }

    public static <T> BaseResult<T> newFailure(int code, String msg, T data) {
        return new BaseResult<>(code, msg, data);
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
