package com.forezp.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//路由的服务过滤功能
@Component
public class MyFilter extends ZuulFilter {


    //返回字符串表示过滤器的类型
    //1.pre 过滤前
    //2.routing 路由之时
    //3.post 路由之后
    //4.error 发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //写判断逻辑，是否要过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑，可以用sql nosql查询是否有权限访问
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken==null){
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false);  //对请求进行路由
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().print("token is empty");
            }catch (Exception e){
                return null;
            }
        }
        System.out.println("route is over");
        return null;
    }
}
