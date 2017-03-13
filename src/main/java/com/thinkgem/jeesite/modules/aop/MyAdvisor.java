package com.thinkgem.jeesite.modules.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.shiro.spring.security.interceptor.AopAllianceAnnotationsAuthorizingMethodInterceptor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@SuppressWarnings({ "unchecked" })
public class MyAdvisor extends StaticMethodMatcherPointcutAdvisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Class<? extends Annotation>[] ANNOTATION_CLASSES = new Class[] { Myannotation.class };

	public MyAdvisor() {
		// TODO Auto-generated constructor stub
		setAdvice(new MyInterceptor());
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		// TODO Auto-generated method stub
		System.out.println("------: " + method.getName());
		Method m = method;
		if (isMyAnnotationPresent(m))
			return true;
		return false;
	}

	private boolean isMyAnnotationPresent(Method method) {
		for (Class<? extends Annotation> annClass : ANNOTATION_CLASSES) {
			Annotation a = AnnotationUtils.findAnnotation(method, annClass);
			if (a != null) {
				return true;
			}
		}
		return false;
	}

}
