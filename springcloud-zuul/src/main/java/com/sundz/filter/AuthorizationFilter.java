package com.sundz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2020/12/23 17:03
 */
@Component
@Log4j2
public class AuthorizationFilter extends ZuulFilter {

    public AuthorizationFilter() {
        super();
    }

    /**
     * @field 是否需要进行过滤  true：需要 false：不需要
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * @field 过滤器具体执行的操作
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String requestURI = request.getRequestURI();
        if (requestURI.contains("api")) {
            // / 不过滤该请求，对其进行路由
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(HttpStatus.OK.value());
            log.info("<--------------------Zuul路由通过-------------------->");
        } else {
            // // 如果参数为空则过滤该请求，不对其进行路由
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
            log.info("<--------------------Zuul路由失败-------------------->");
        }
        return null;
    }

    /**
     * @field 主要有四种取值：pre,route,post,error
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
