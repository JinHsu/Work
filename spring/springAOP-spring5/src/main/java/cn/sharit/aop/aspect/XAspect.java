package cn.sharit.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Around: 环绕前通知
 * @Before: 前置通知
 * xxxService业务逻辑
 * throwable=java.lang.ArithmeticException: / by zero
 * result=123方法返回
 * @AfterReturning: 返回通知
 * @AfterThrowing: 异常通知
 * @After: 后置通知
 * @Around: 环绕后通知
 */
@Aspect // 切面声明
@Component
public class XAspect {

    @Pointcut("execution(* cn.sharit.aop..*(..))") // 切入点声明：切入点表达式
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint pjp) {
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

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("result=" + result);
        System.out.println("@AfterReturning: 返回通知");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "throwable")
    public void afterThrowing(Throwable throwable) {
        System.out.println("throwable=" + throwable);
        System.out.println("@AfterThrowing: 异常通知");
    }

}
