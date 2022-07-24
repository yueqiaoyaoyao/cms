package com.cms.handler;

import com.alibaba.fastjson.JSON;
import com.cms.pojo.utils.ResponseResult;
import com.cms.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(
                HttpStatus.UNAUTHORIZED.value(), "用户认证失败，请重新登录");
        String Json = JSON.toJSONString(result);
        WebUtils.renderString(httpServletResponse,Json);
    }
}
