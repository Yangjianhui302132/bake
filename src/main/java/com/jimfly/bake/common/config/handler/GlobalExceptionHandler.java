package com.jimfly.bake.common.config.handler;

import com.jimfly.bake.entity.common.BaseResponse;
import com.jimfly.bake.entity.exception.BusinessException;
import com.jimfly.bake.entity.exception.enums.ExceptionInfoEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public BaseResponse businessExceptionHandler(HttpServletRequest req, BusinessException e){
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return BaseResponse.getResponse(e.getErrorCode(),false,e.getErrorMsg(),null);
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public BaseResponse nullPointerExceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生业务异常！原因是：{}",e.getMessage());
        return BaseResponse.getResponse(ExceptionInfoEnum.NULL_POINTER.getResultCode(),false,e.getMessage(),null);
    }

}
