package com.gyx.service;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;

/**
 * 后置拦截器
 * Created by hp on 2018/7/11.
 */
@Component
public class PostFilter extends ZuulFilter {
    /**
     * 拦截器类型，默认有四种，前置（PRE），路由（ROUTE），后置(POST)，错误(ERROR)
     * @return
     */
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    /**
     * 默认为 5，返回值越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return SEND_ERROR_FILTER_ORDER - 1;
    }

    /**
     * 是否启动拦截器，实际应用中可添加逻辑方法去控制,这里设置默认打开
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        response.setHeader("Rocsun-G","gyx");
        return null;
    }
}
