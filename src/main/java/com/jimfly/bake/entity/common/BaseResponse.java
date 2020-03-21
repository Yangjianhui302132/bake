package com.jimfly.bake.entity.common;

import lombok.Data;

/**
 * 基础返回信息
 * 返回前端对象
 */
@Data
public class BaseResponse<T> {
    private Integer code;//编码
    private boolean success;//是否成功
    private String msg;//返回信息
    private T obj;
    //隐藏默认构造器
    private BaseResponse(){}

    public static <T> BaseResponse<Object> getResponse(Integer code,boolean success,String msg,T obj){
        BaseResponse<Object> br = new BaseResponse<>();
        br.setCode(code);
        br.setMsg(msg);
        br.setObj(obj);
        br.setSuccess(success);
        return br;
    }

    public static <T> BaseResponse<Object> getSuccessResponse(T obj,String msg){
        return getResponse(ResponseCodeEnum.SUCCESS.code,true,msg,obj);
    }

    public static <T> BaseResponse<Object> getSuccessResponse(T obj){
        return getSuccessResponse(obj,null);
    }

    public static <T> BaseResponse<Object> getSuccessResponse(String msg){
        return getSuccessResponse(null,msg);
    }

    public static <T> BaseResponse<Object> getFailResponse(T obj,String msg){
        return getResponse(ResponseCodeEnum.FAIL.code,false,msg,obj);
    }

    public static <T> BaseResponse<Object> getFailResponse(T obj){
        return getFailResponse(obj,null);
    }

    public static <T> BaseResponse<Object> getFailResponse(String msg){
        return getFailResponse(null,msg);
    }

    public static <T> BaseResponse<Object> getErrorResponse(T obj,String msg){
        return getResponse(ResponseCodeEnum.ERROR.code,false,msg,obj);
    }

    public static <T> BaseResponse<Object> getErrorResponse(T obj){
        return getErrorResponse(obj,null);
    }

    public static <T> BaseResponse<Object> getErrorResponse(String msg){
        return getErrorResponse(null,msg);
    }

    enum ResponseCodeEnum{
        SUCCESS(1,"成功"),
        FAIL(0,"失败"),
        ERROR(-1,"异常");
        private Integer code;
        private String value;
        private ResponseCodeEnum(Integer code,String value){
            this.code = code;
            this.value = value;
        }
    }
}
