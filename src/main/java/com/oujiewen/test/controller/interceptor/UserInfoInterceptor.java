package com.oujiewen.test.controller.interceptor;

import com.oujiewen.test.Exception.ErrorMsg;
import com.oujiewen.test.Exception.GraceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {
    /**
     * 请求访问到controller之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId=request.getHeader("userId");
        String userToken=request.getHeader("userToken");

        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(userToken)){
            log.error("用户参数为空");
            GraceException.display(ErrorMsg.login_info_null);
            return false;
        }
        if(!userId.equals("123") || !userToken.equals("abc")){
            log.error("登录信息错误");
            GraceException.display(ErrorMsg.login_info_error);
            return false;
        }
        return true;
    }

    /**
     * 请求进入controller之后，在试图渲染之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 请求在访问controller之后，视图渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
