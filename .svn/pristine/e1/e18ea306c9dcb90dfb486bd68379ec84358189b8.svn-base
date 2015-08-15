package com.cqgs.app.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cqgs.app.common.trade.ResponseResult;
import com.cqgs.app.common.trade.ResponseStatus;

/**
 * Created by fuda on 15/8/12.
 */
public class RequestTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uid = request.getParameter("uid");

        if ("x".equals(uid)) {
            ResponseResult webApiResponse = new ResponseResult.Builder(ResponseStatus.INVALID_TOKEN).message("非法请求").build();
            writeResponseJson(response, webApiResponse);
            return false;
        }

        return true;
    }

    private void writeResponseJson(HttpServletResponse response, ResponseResult webApiResponse) throws IOException {
        String jsonStr = JSONObject.toJSONString(webApiResponse);
        response.setContentType("text/html;charset=UTF-8");
        response.getOutputStream().write(jsonStr.getBytes("UTF-8"));
        response.getOutputStream().flush();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
