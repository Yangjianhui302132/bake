package com.jimfly.bake.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SpringUtils {
    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取session
     * @return
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    /**
     * 获取response
     */
    public static HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
