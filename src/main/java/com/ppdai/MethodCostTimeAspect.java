package com.ppdai;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author hxt
 * @version 1.0
 * @date 2021/3/28
 */
@Aspect
public class MethodCostTimeAspect {
    @Pointcut("execution(* com.ppdai..*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object logProfile(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        System.out.println(joinPoint.getSignature() + " 方法耗时： " + (System.currentTimeMillis() - start) + "ms");
        return result;
    }
}
