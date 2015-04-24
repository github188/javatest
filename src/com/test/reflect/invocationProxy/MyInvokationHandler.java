package com.test.reflect.invocationProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvokationHandler implements InvocationHandler {

	/**
	 * ִ�ж�̬�����������з��������ᱻ�����ִ�����µ�invoke����,���ǿ����������������һЩ����Ĵ���
	 * ����hibernate����������ִ��insert��update�ȷ�����ʱ�򣬼��뿪���͹ر�����ķ�����
	 * ���У�
	 *  proxy ����̬�������
	 *  method ��������ִ�еķ���
	 *  args ����ִ�д�����󷽷�ʱ�Ĳ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("����ִ�еķ�����" + method);
		if (args != null) {
			for (Object arg : args) {
				System.out.println("����"+arg);
			}
		} else {

		}
		return null;
	}

	public static void main(String[] args) {
		InvocationHandler invoke = new MyInvokationHandler();
		Person p = (Person) Proxy.newProxyInstance(Person.class
				.getClassLoader(), new Class[] { Person.class }, invoke);
//		Person p = (Person)GenericProxyFactory.getProxy(Person.class, new PersonImpl());
		p.walk();
		p.sayHello("charles");
	}

}
