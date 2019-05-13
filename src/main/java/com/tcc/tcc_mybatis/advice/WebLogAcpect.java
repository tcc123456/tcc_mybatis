package com.tcc.tcc_mybatis.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;


@Component
@Aspect
public class WebLogAcpect {
    private Logger logger = LoggerFactory.getLogger(WebLogAcpect.class);

/*    *
     * 定义切入点，切入点为com.tcc.tcc_mybatis.advice.WebLogAcpect下的所有函数*/

    @Pointcut("execution(* com.tcc.tcc_mybatis.service.*Service.*(..))")
    public void webLog(){}

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable*/

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        Object id=session.getAttribute("usrid");

        // 记录下请求内容
       System.out.println("URL : " + request.getRequestURL().toString());
       System.out.println("HTTP_METHOD : " + request.getMethod());
       System.out.println("IP : " + request.getRemoteAddr());
       System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
       System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
       System.out.println("RESPONSE : " + ret);
    }

}
