package com.tokeys.interceptor;

import com.tokeys.token.JWTConstant;
import com.tokeys.token.TokenManage;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class TokenInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<String, Object> map = new HashMap<>();
        String accessToken = request.getHeader("accessToken");
        if (null == accessToken || "".equals(accessToken)) {
            map.put("code", -1);
            map.put("msg", "accessToken is null");
            response.getWriter().write(map.toString());
            return false;
        } else {
            map = TokenManage.MANAGE.validate(accessToken);
            if (null == map.get(JWTConstant.JWT_ERRCODE_CODE.getVlaue())) {
                return true;
            } else {
                response.getWriter().write(map.toString());
                return false;

            }

        }


    }

    /*
     *
     * 请求处理之后进行调用，但是在视图被渲染之前(Controller方法调用之后)
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /*
     *
     * 在整个请求结束之后被调用，也就是在DispatcherServlet渲染了对应的视图之后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
