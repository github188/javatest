package com.test.extend;

public class Test extends T1{

	//��д����Ĺ��췽����û�á�
	public void T1() {
		System.out.println("test");
	}
	public Test() {
		System.out.println("Test");
	}

	public static void main(String[] args) {
		//T1 t = new Test();
		//�ȳ�ʼ�����࣬�ڳ�ʼ�����࣬�ڵ��÷�����
		new Test().T1();
	}
}
