package com.heaven.learnspringaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Around("execution(* com.heaven.learnspringaop.*.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Start a timer
        long startTimemilis = System.currentTimeMillis();
        //Execute the method
        Object returnValue = proceedingJoinPoint.proceed();
        //Stop the timer
        long stopTImemillis = System.currentTimeMillis();
        long executionDuration = stopTImemillis-startTimemilis;
        logger.info("Around Aspect - {} method executed in {} ms",proceedingJoinPoint,executionDuration);
        return returnValue;
    }
}
