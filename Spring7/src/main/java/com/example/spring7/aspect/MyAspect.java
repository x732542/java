package com.example.spring7.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MyAspect {

	public MyAspect() {
		System.out.println("MyAspect()");
	}
	
	@Pointcut("execution(* com.example.spring7.controller..*(..))")
	public void doAllController() {}

	@Pointcut("execution(* com.example.spring7.controller.TestController.*(..))")
	public void doTestController() {}
	
	//------------------------------------
	@Before("doAllController()")
	public void doBefore() {
		System.out.println("doBefore()");
	}
	
	@After("doAllController()")
	public void doAfter() {
		System.out.println("doAfter()");
	}
	
	@Around("doTestController()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around1");
		Object obj = joinPoint.proceed();
		System.out.println("around2");
		return null;
	}

}