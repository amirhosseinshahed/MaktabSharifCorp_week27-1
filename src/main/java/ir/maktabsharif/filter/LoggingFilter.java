package ir.maktabsharif.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("filter was initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(request.getRemoteAddr());
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        System.out.println(request1.getMethod());
        System.out.println(request1.getRequestURI());
        System.out.println(new java.util.Date());
        chain.doFilter(request1 , response1);
        System.out.println(new java.util.Date() +"  Response sent");

    }

    @Override
    public void destroy() {
        System.out.println("the filter has been destroyed");
    }
}
