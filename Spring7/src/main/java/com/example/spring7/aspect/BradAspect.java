package com.example.spring7.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BradAspect {
	
	@Around("@annotation(com.example.spring7.annotation.BradAOP)")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		
		String methodName =  joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(args.length);
		System.out.println(args[0]);
		System.out.println(args[1]);
		args[0] = args[0].toString().toUpperCase();
		
		Object obj = joinPoint.proceed(args);
		
		System.out.println("time:" + (System.currentTimeMillis() - start));
		return null;
	}
}