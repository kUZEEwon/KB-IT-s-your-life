package com.multi.spring2.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConfig3 {

    public AOPConfig3(){
        System.out.println("AppConfig3 created");
    }

    @Bean
    public AOPConfig3.AspectClass3 aspect() {
        return new AOPConfig3.AspectClass3();
    }


    @Aspect
    public static class AspectClass3 {

        private Map<String, Long> methodExecutionCount = new HashMap<>();
        private Map<String, Long> methodExecutionTime = new HashMap<>();

        @Around("execution(* com.multi.spring2.aop.service.ASiteService.ano*(..))")
        public Object recordExecutionStats(ProceedingJoinPoint joinPoint) throws Throwable {
            String methodName = joinPoint.getSignature().toShortString();

            long start = System.currentTimeMillis();
            Object proceed = joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - start;

            methodExecutionCount.put(methodName, methodExecutionCount.getOrDefault(methodName, 0L) + 1);
            methodExecutionTime.put(methodName, methodExecutionTime.getOrDefault(methodName, 0L) + executionTime);

            long count = methodExecutionCount.get(methodName);
            long totalTime = methodExecutionTime.get(methodName);
            long averageTime = totalTime / count;

            System.out.println(methodName + " called " + count + " times, average execution time: " + averageTime + "ms");

            return proceed;
        }

        @Around("execution(* com.multi.spring2.aop.service.ASiteService.per*(..))")
        public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();

            Object proceed = joinPoint.proceed();

            long executionTime = System.currentTimeMillis() - start;
            System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

            return proceed;
        }
    }
}


