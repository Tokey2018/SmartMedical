package com.tokeys.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * API 拦截器 : FIXME  上线前放开拦截
 * spring boot 2.0 WebMvcConfigurerAdapter过时解决方法
 * https://blog.csdn.net/hehe1006114318/article/details/80422721
 */


@Configuration
public class ApiConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Api 请求拦截 excludePathPatterns("")
        /*registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/api/*");*/
        //TODO 其他拦截... .
    }

    /**
     * 添加跨域
     * @param registry
     */


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("*")//设置允许跨域请求的域名
                .allowCredentials(true)//是否允许证书 不再默认开启
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH","OPTIONS")//设置允许的方法
                .allowedHeaders("accessToken","Accept","Origin","No-Cache"," X-Requested-With","If-Modified-Since","Pragma","Last-Modified","Cache-Control","Expires","Content-Type","X-E4M-With")
                .maxAge(360000);//跨域允许时间
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
