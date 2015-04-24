package com.test.innerclass;
/**
 * 
 * @author �ų�
 * 2012-2-28����03:10:15
 * ���һ���࣬�̳е���ͽӿ�������ͬ�ķ�������ô�������ڲ��໹ʵ�ֽӿ��еķ�����
 */
public class TestClass extends AbstractClass implements InterfaceClass {

	/**
	 * ���ʵ���ǳ������е�run������
	 *
	 */
	@Override
	public void run() {
		System.out.println("this is abstract run()");
	}

	class inner implements InterfaceClass{
		@Override
		public void run() {
			System.out.println("this is interface run()");
		}
	}
	public static void main(String[] args) {
		TestClass tc = new TestClass();
		tc.run();
		inner in = tc.new inner();
		in.run();
	}
	
}
