package com.thinkgem.jeesite.modules.aop;

import java.lang.reflect.AccessibleObject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("处理前");
		Object object = invocation.getMethod().
				invoke(invocation.getThis(),invocation.getArguments());
		AccessibleObject accessibleObject = invocation.getStaticPart();
		System.out.println("处理后");
		return object;
	}

}
