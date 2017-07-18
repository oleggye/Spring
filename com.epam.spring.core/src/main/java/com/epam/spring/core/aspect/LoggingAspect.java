package com.epam.spring.core.aspect;

import java.util.concurrent.CountDownLatch;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	private static int count = 0;
	
	private static final int MAX_ALLOWED = 1;

	@Pointcut("execution(* *.logEvent(..))")
	public void allLogEventMethods() {
	}
	
	@Before("allLogEventMethods()")
	public void logBefore(JoinPoint joinPoint) {
		String str = 
				"BEFORE :"+
				joinPoint.getTarget()
						 .getClass().getSimpleName()
				+ " " + 
				joinPoint.getSignature()
						 .getName();
		System.out.println(str);
	}
	
	@After("allLogEventMethods()")
	public void logAfter(JoinPoint joinPoint) {
		
		System.out.println("AFTER");
	}
	
//	@Around("consoleLoggerMethods() && args(evt)")
//	public void aroundLogEvent(ProceedingJoinPoint jp, Object evt) {
//		count++;
//		
//		if(count < MAX_ALLOWED) {
//			try {
//				jp.proceed(new Object[] {evt});
//			} catch (Throwable e) {
//				e.printStackTrace();
//			}
//		}else {
//			//FIXME:
//		}
//	}
}