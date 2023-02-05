package com.heaven.learnspringaop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CommonPointCutConfig {
    @Pointcut("execution(* com.heaven.learnspringaop.*.*.*(..))")
    public void businessAndDataPackageConfig(){

    }
}
