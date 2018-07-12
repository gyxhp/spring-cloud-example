package com.gyx.service;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 前置拦截器
 * Created by hp on 2018/7/11.
 */
@Component
public class PreFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 5;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。这里通过 requestContext.setSendZuulResponse(false) 令 Zuul 过滤该请求，
     * 不对其进行路由，然后通过 requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value())
     * 设置了其返回的错误码，当然也可以对返回的结果进行优化，比如，通过 requestContext.setResponseBody(body) 对返回的 body 内容进行编辑等。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            log.warn("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            return null;
        }
        log.info("token is ok");
        return null;
    }
}
