package com.lab.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(com.lab.lab.aspect.annotation.ExecutionTime)")
    public void executionTime(){}

    @Around("executionTime()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("********** EXECUTION TIME ASPECT ************");
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long end = System.nanoTime();
        double seconds = (double)(end - start) / 1_000_000_000;
        System.out.println(joinPoint.getSignature().getName() + " Time Taken In Seconds: " + seconds);
        return result;

    }


}
