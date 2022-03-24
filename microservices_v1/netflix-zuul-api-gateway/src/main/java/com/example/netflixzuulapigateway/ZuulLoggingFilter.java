package com.example.netflixzuulapigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override // should filtering happen before the request is executed or after the
    // request is executed or we want to filter only error request.
    // Value could be "pre", "post", "error"
    public String filterType() {
        return "pre";
    }

    @Override // what is the execution order for this filter
    public int filterOrder() {
        return 1;
    }

    @Override // should this filter be executed or not for every request.
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri-> {}", request, request.getRequestURI());
        return null;
    }
}
