package com.jimfly.bake.common.config;

import com.jimfly.bake.common.config.interceptor.LoginHandlerInterceptor;
import com.jimfly.bake.common.config.interceptor.ViewContextInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;
    @Autowired
    private ViewContextInterceptor viewContextInterceptor;

    /**
     * 默认访问的是登录页
     *
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册登陆拦截器
        registry.addInterceptor(loginHandlerInterceptor)
                //拦截地址
                .addPathPatterns("/member/**","/api/member/**")
                //过滤地址
                .excludePathPatterns(
                 //登陆放行
                 "/login","/login/submit",
                 //放行静态资源
                 "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg",
                 "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg","/**/*.json");
        //注册页面上下文参数拦截器
        registry.addInterceptor(viewContextInterceptor)
                //拦截地址
                .addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler请求路径
        //addResourceLocations 在项目中的资源路径
        //setCacheControl 设置静态资源缓存时间
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
    }
}
