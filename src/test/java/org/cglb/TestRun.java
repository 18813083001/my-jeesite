package org.cglb;

import net.sf.cglib.proxy.Proxy;

public class TestRun {

	public static void main(String []args)
	{
		runCglibProxy();
	}
	
	private static void runCglibProxy(){
		CglibProxy vcCglibProxy = new CglibProxy();
		Hello helloProxy = vcCglibProxy.getProxy(Hello.class);
		helloProxy.say("cglib");
		helloProxy.listen("a", "b");
	}
}
