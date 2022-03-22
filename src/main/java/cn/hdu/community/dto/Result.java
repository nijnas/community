package cn.hdu.community.dto;

import lombok.Data;

import java.util.Objects;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
@Data
public class Result {
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 404;
    private static final String SUCCESS_MSG = "操作成功";
    private static final String ERROR_MSG = "操作失败";

    private int code;   //返回状态码
    private String msg; //返回的信息
    private Object data;     //返回的数据

    public static Result success() {
        Result r = new Result();
        r.setCode(SUCCESS_CODE);
        r.setMsg(SUCCESS_MSG);
        return r;
    }

    public static Result success(String msg, Object data) {
        Result r = new Result();
        r.setMsg(Objects.requireNonNullElse(msg, SUCCESS_MSG));
        r.setCode(SUCCESS_CODE);
        r.setData(data);
        return r;
    }

    public static Result error() {
        Result r = new Result();
        r.setCode(ERROR_CODE);
        r.setMsg(ERROR_MSG);
        return r;
    }

    public static Result error(String msg, Object data) {
        Result r = new Result();
        r.setMsg(Objects.requireNonNullElse(msg, ERROR_MSG));
        r.setCode(ERROR_CODE);
        r.setData(data);
        return r;
    }
}
