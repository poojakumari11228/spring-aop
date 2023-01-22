package com.lab.lab.aspect;

import com.lab.lab.entity.Exception;
import com.lab.lab.entity.Logger;
import com.lab.lab.repo.ExceptionLoggerRepo;
import com.lab.lab.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    private final LoggerRepo loggerRepo;
    private final ExceptionLoggerRepo exceptionLoggerRepo;

    @Autowired
    LoggingAspect(LoggerRepo loggerRepo, ExceptionLoggerRepo exceptionLoggerRepo) {
        this.loggerRepo = loggerRepo;
        this.exceptionLoggerRepo = exceptionLoggerRepo;
    }

    @Pointcut("execution(* com.lab.lab.controller.*.*(..))")
    public void logging() {
    }

    @Before("logging()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("*************** " + joinPoint.getSignature().getName());
        Logger logger = new Logger(new Date(), "Demo", joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName());
        loggerRepo.save(logger);
    }

    @AfterThrowing(value = "logging()", throwing = "exception")
    public void exceptionLogging(JoinPoint joinPoint, Throwable exception) {
        System.out.println("********** " + joinPoint.getSignature().getName() );

        Exception exceptionLog = new Exception(new Date(), "Demo", joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName(), exception.getMessage().toString());
        exceptionLoggerRepo.save(exceptionLog);
    }

}
