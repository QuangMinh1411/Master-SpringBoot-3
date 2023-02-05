package com.heaven.learnspringaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());



    @Before(value = "com.heaven.learnspringaop.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){
        logger.info("Before Aspect -{} is called with arguments {}",joinPoint,joinPoint.getArgs());

    }

    @After(value = "execution(* com.heaven.learnspringaop.aspects.CommonPointCutConfig.businessAndDataPackageConfig())")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        logger.info("After Aspect -{} has executed",joinPoint);

    }
    @AfterThrowing(pointcut = "execution(* com.heaven.learnspringaop.*.*.*(..))",
    throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint,Exception exception){
        logger.info("After Throwing Aspect - {}  has thrown an exception {}",joinPoint,exception);

    }

    @AfterReturning(pointcut = "execution(* com.heaven.learnspringaop.aspects.CommonPointCutConfig.businessAndDataPackageConfig())",returning = "resultValue")
    public void logMethodCallAfterSuccessExecution(JoinPoint joinPoint, Object resultValue){
        logger.info("After returning object -{} has returned {}",joinPoint,resultValue);

    }
}
