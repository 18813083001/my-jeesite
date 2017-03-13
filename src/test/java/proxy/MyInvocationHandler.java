package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.servlet.DispatcherServlet;

public class MyInvocationHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("befor");
		method.invoke(proxy, args);
		System.out.println("after");
		return null;
	}

}
