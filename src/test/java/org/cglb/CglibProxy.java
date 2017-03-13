package org.cglb;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

import org.apache.tools.ant.taskdefs.Java;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.transform.impl.UndeclaredThrowableStrategy;
import org.springframework.core.SmartClassLoader;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import CglibProxy.MyAdviseInterceptor;
import CglibProxy.MyDynamicAdviseInterceptor;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	private static CglibProxy instance = new CglibProxy();
	
	public CglibProxy(){}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("befor");
		
		Object object = arg3.invokeSuper(arg0, arg2);
		System.out.println("after");
		return object;
	}
	
	public static CglibProxy getInstance(){
		return instance;
	}
	
	public <T> T  getProxy(Class<?> cls)
	{

//		Class<?> rootClass = this.advised.getTargetClass();
//		Assert.state(rootClass != null, "Target class must be available for creating a CGLIB proxy");
//
//		Class<?> proxySuperClass = rootClass;
//		if (ClassUtils.isCglibProxyClass(rootClass)) {
//			proxySuperClass = rootClass.getSuperclass();
//			Class<?>[] additionalInterfaces = rootClass.getInterfaces();
//			for (Class<?> additionalInterface : additionalInterfaces) {
//				this.advised.addInterface(additionalInterface);
//			}
//		}
//
//		// Validate the class, writing log messages as necessary.
//		validateClassIfNecessary(proxySuperClass, classLoader);
//
//		// Configure CGLIB Enhancer...
//		Enhancer enhancer = createEnhancer();
//		if (classLoader != null) {
//			enhancer.setClassLoader(classLoader);
//			if (classLoader instanceof SmartClassLoader &&
//					((SmartClassLoader) classLoader).isClassReloadable(proxySuperClass)) {
//				enhancer.setUseCache(false);
//			}
//		}
//		enhancer.setSuperclass(proxySuperClass);
//		enhancer.setInterfaces(AopProxyUtils.completeProxiedInterfaces(this.advised));
//		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
//		enhancer.setStrategy(new UndeclaredThrowableStrategy(UndeclaredThrowableException.class));
//
//		Callback[] callbacks = getCallbacks(rootClass);
//		Class<?>[] types = new Class<?>[callbacks.length];
//		for (int x = 0; x < types.length; x++) {
//			types[x] = callbacks[x].getClass();
//		}
//		// fixedInterceptorMap only populated at this point, after getCallbacks call above
//		enhancer.setCallbackFilter(new ProxyCallbackFilter(
//				this.advised.getConfigurationOnlyCopy(), this.fixedInterceptorMap, this.fixedInterceptorOffset));
//		enhancer.setCallbackTypes(types);
//
//		// Generate the proxy class and create a proxy instance.
//		return createProxyClassAndInstance(enhancer, callbacks);
	
		Enhancer enhancer = new Enhancer();
		enhancer.setClassLoader(this.getClass().getClassLoader());
		enhancer.setSuperclass(Hello.class);
		enhancer.setInterfaces(new Class[]{MethodInterceptor.class});
		net.sf.cglib.proxy.Callback callback = new MyDynamicAdviseInterceptor();
		net.sf.cglib.proxy.Callback callback2 = new MyAdviseInterceptor();
		
		net.sf.cglib.proxy.Callback callback3[] = {callback,callback2};
		
		Class<?> class1[] = new Class[callback3.length];
		for(int i = 0; i < callback3.length;i++){
			class1[i] = callback3[i].getClass();
		}
		enhancer.setCallbacks(callback3);
		enhancer.setCallbackTypes(class1);
		enhancer.setCallbackFilter(new ProxyCallbackFilter());
		//enhancer.setCallback(callback);
		@SuppressWarnings("unchecked")
		//T create = (T)enhancer.create(new Class[]{String.class}, new String[]{"123"});
		T create = (T)enhancer.create();
		return create;
	}
	
	@SuppressWarnings("unused")
	private class ProxyCallbackFilter implements CallbackFilter
	{

		@Override
		public int accept(Method method) {
			// TODO Auto-generated method stub
			if(method.getName().equals("say"))
			return 0;
			else if(method.getName().equals("listen"))
			return 1;
			else return 0;
		}
		
	}

}
