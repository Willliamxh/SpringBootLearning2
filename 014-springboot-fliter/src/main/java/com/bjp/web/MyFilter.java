package com.bjp.web;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //正常情况下，在过滤器是访问url之前执行的，也就是controller之前
        System.out.println("执行了MyFilter，doFilter ");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
