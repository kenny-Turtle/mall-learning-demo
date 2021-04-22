package com.macro.mall.tiny.common.api;

/*
* 通用返回对象
* */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    //返回成功结果，默认码和提示，传数据
    public static<T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }
    //返回成功结果，默认码，传数据和提示
    public static<T> CommonResult<T>success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }
    //失败返回结果，默认提示，传码
    public static<T> CommonResult<T> failed(IErrorCode iErrorCode){
        return new CommonResult<T>(iErrorCode.getCode(),iErrorCode.getMessage(),null);
    }
    //失败返回结果，默认码，传提示
    public static<T> CommonResult<T> failed(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
    }
    public static<T> CommonResult<T> failed(){
        return failed(ResultCode.FAILED);
    }
    //参数验证失败返回结果
    public static<T> CommonResult<T> validateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }
    //参数验证失败返回结果，传提示信息
    /** 
    * @Description:  
    * @Param: 
    * @return: 
    * @Author: Jay
    * @Date: 2021/4/19
    */
    public static<T> CommonResult<T> validateFailed(String message){
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }
    /** 
    * @Description:
    * @Param: [data]
    * @return: com.macro.mall.tiny.common.api.CommonResult<T>
    * @Author: Jay
    * @Date: 2021/4/20 9:20 下午
    */
    public static<T> CommonResult<T> unauthorized(T data){
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),data);
    }


    public CommonResult() {
    }

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
