package proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Class[] classes = {MyProxyClass.class};
		MyInvocationHandler handler = new MyInvocationHandler();
		MyProxyInterface myProxyClass2 = (MyProxyInterface) Proxy.newProxyInstance(MyProxyClass.class.getClassLoader(), 
				classes,handler);
		myProxyClass2.pring();
	}
}
