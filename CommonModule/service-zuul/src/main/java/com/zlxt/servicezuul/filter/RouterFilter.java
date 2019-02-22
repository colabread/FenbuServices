package com.zlxt.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RouterFilter extends ZuulFilter {

    /**
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;   //数字越小，优先级越高
    }

    /**
     * 判断是否要进行过滤
     * @return false：不过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String method = request.getMethod();
        String url = request.getRequestURL().toString();
        System.out.println("request method : " + method);
        System.out.println("request url : " + url);
        String token = request.getParameter("token");
        if(token == null || token.replace(" ", "").length() == 0){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(403);
            try {
                requestContext.getResponse().getWriter().write("token invalid");
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
        return null;
    }
}
