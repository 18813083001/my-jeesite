package CglibProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class MyDynamicAdviseInterceptor implements MethodInterceptor, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("MyDynamicAdviseInterceptor");
		//method.invoke(obj, args);
		Object object = proxy.invokeSuper(obj, args);
		return object;
	}

	

}
