package com.epam.spring.core.aspect;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StatisticsAspect {

	private Map<Class<?>, Integer> counter;

	public void setCounter(Map<Class<?>, Integer> counter) {
		this.counter = counter;
	}

	@AfterReturning("execution(* *.logEvent(..))")
	public void count(JoinPoint joinPoint) {
		Class<?> clazz = joinPoint.getTarget().getClass();
		if (!counter.containsKey(clazz)) {
			counter.put(clazz, 0);
		}
		counter.put(clazz, counter.get(clazz) + 1);
	}
}