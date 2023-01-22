package com.lab.lab.aspect;

import com.lab.lab.entity.Logger;
import com.lab.lab.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    private final LoggerRepo loggerRepo;

    @Autowired
    LoggingAspect(LoggerRepo loggerRepo){
        this.loggerRepo = loggerRepo;
    }

    @Pointcut("execution(* com.lab.lab.controller.*.*(..))")
    public void logging() {
    }

    @Before("logging()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("*************** "+joinPoint.getSignature().getName());
        Logger logger = new Logger(new Date(), "Demo", joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringTypeName());
        loggerRepo.save(logger);
    }

}
