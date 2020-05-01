package de.pottmeier.common;

import org.apache.log4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class ContextFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.getenv().forEach( (k,v)   -> {
            MDC.put("env."+k, v);
        });
        MDC.put("req.remoteHost", servletRequest.getRemoteHost());


        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
