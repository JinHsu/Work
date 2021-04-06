package cn.sharit.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Around: 环绕前通知
 * @Before: 前置通知
 * xxxService
 * @Around: 环绕后通知
 * @After: 后置通知
 * @AfterReturning: 返回通知
 * @AfterThrowing: 异常通知
 */
@Aspect
@Component
public class XAspect {

    @Pointcut("execution(* cn.sharit.aop..*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("@Before: 前置通知");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("@After: 后置通知");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@Around: 环绕前通知");
        Object o = pjp.proceed();

        System.out.println("@Around: 环绕后通知");
        return o;
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("@AfterReturning: 返回通知");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("@AfterThrowing: 异常通知");
    }

}
