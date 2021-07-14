package com.one.learn.resttemplate.hadler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("StopWatch-StartTime");

    //在controller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //使用threadlocal 监控每个接口的调用时间
        // 1,开始时间
        long startTime = System.currentTimeMillis();
        // 线程绑定变量(该数据只有当前请求的线程可见)
        startTimeThreadLocal.set(startTime);



        System.out.println("拦截器preHandle 在controller之前执行");
        String id = request.getParameter("id");
        if ("1".equals("1")){
            System.out.println("拦截器拦截了"+id);
            //response.sendRedirect("/login.html");
          //  throw new RuntimeException("error ....");
//            return true;//若是zhangsan拦截
        }
        return true;//返回true放行 返回falser 拦截
    }
    //在controller执行之后，跳转页面之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器postHandle 在controller执行之后，跳转页面之前执行");
    }
    //所有操作完毕之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器afterCompletion 所有操作完毕之后执行");

        // 2.结束时间
        long endTime = System.currentTimeMillis();
        // 得到线程绑定的局部 变量(开始时间)
        long beginTime = startTimeThreadLocal.get();
        // 3.计算消耗时间
        long consumeTime = endTime - beginTime;
        log.error("监控==========================： "
        + String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
        startTimeThreadLocal.remove();

    }
}

