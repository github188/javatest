package com.test.classs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassGetter {

	// java������Ƶ�ʵ��
	public static JavaBeanExp converStr2ServerBean(String beanName,
			String fieldSetter, String paraValue) {
		JavaBeanExp base = null;
		try {
			Class cls = Class.forName(beanName);
			base = (JavaBeanExp) cls.newInstance();// ��ø����һ��ʵ��
			Class[] paraTypes = new Class[] { String.class };
			Method method = cls.getMethod(fieldSetter, paraTypes);
			String[] paravalues = new String[] { paraValue };
			method.invoke(base, paravalues);
		} catch (Throwable e) {
			System.err.println(e);
		}
		return base;
	}

	public static void main(String[] args) throws Exception {
		/*JavaBeanExp bean = (JavaBeanExp) ClassGetter.converStr2ServerBean("com.test.classs.JavaBeanExp", "setName", "����");

		// �����൱��ִ����JavaBeanExp���setName(������")������
		System.out.println(bean.getName());*/

		Class cls = Class.forName("com.test.classs.JavaBeanExp");
		Class[] paramTypes = { String.class};
		Object[] params = { "charles" }; // ��������Ĳ���

		Constructor<?> con = cls.getConstructor(paramTypes); // ��Ҫ���������
		JavaBeanExp base = (JavaBeanExp) con.newInstance(params);
		System.out.println(base);
	}

}
