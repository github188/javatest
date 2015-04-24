package com.test.reflect.invocationProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * ������Ҳ���ñ�д�������������ˣ�����봴���������ȫ�ذѶ��������ڽӿ� T��ֻҪ���� getProxy(T.class,object)
 * �Ϳ����ˣ�����Ҫһ����������Ķ�����׸��
 * 
 * 
 * 2012-6-26����06:08:48 ͨ�õ�����������������
 */
public class GenericProxyFactory {
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> intf, final T obj) {
		return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				new Class[] { intf }, new InvocationHandler() {
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("�������--");
						Object result = method.invoke(obj, args);
						System.out.println("----");
						return result;
					}
				});
	}
	
	
	public static void main(String[] args) {
		Person p = GenericProxyFactory.getProxy(Person.class,new PersonImpl());
		p.sayHello("haha");
		p.walk();
	}
}
