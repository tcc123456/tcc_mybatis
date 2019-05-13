//package com.tcc.tcc_mybatis.advice;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//
//
//
//@Aspect
//@Component("myadvice")
//public class Myadvice {
//
//    @Before("execution(* com.tcc.tcc_mybatis.service.*Service.*(..))")
//    public void before(){
//
//        System.out.println("这是前置通知-----");
//
//}
//    @AfterReturning("execution(* com.tcc.tcc_mybatis.service.*Service.*(..))")
//    public void afterReturning(){
//    System.out.println("这是后置通知");
//}
//    @Around("execution(* com.tcc.tcc_mybatis.service.*Service.*(..))")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("这是环绕通知之前的部分");
//        Object proceed = pjp.proceed();//调用目标方法
//        System.out.println("这是环绕通知之后的部分");
//        return proceed;
//    }
//    @AfterThrowing("execution(* com.tcc.tcc_mybatis.service.*Service.*(..))")
//   public  void afterException(){
//       System.out.println("出异常了");
//   }
//    public  void after(){
//    System.out.println("这是后置通知(出现异常也会调用)");
//}
//}
