package com.test.innerclass;

public class InnerClass {

	private int a = 1;
	private static int b = 2;

	class A {
		public void outA() {
			System.out.println(a + "  A outA()");
		}
	}

	// ��̬�ڲ��࣬���ܵ����ⲿ��ķǾ�̬����
	static class B {
		private void outB() {
			System.out.println(b + " B outB()");
			new InnerClass().new A().outA();
		}
	}

	// �����ڲ���,ʹ�õı������ڵ����ԣ�������final�ġ�
	public void methodA() {
		final int c = 0;
		class innerA {
			private void innerMethodClass() {
				System.out.println("innerMethodClass  " + c);
			}
		}
		innerA ia = new innerA();
		ia.innerMethodClass();
	}

	interface InnerA{
		void inA();
	}
	// �����ڲ���
	public void methodB(final int a){
		InnerA aa =new InnerA(){
			@Override
			public void inA() {
				System.out.println(a+"  �ӿ�ʽ�����ڲ���methodB");
			}
		};
		aa.inA();
	}

	//�̳��ǵ������ڲ��࣬���outA������A�ڲ�������private����ô��C���еķ���outA��û����дA��ķ����ġ�
	class C{
		A aaa = new A(){
			public void outA() {
				System.out.println("�̳�ʽ�������ڲ���");
			}
		};
	}
	
	public static void main(String[] args) {
		InnerClass ic = new InnerClass();
		ic.new A().outA();
		new B().outB();
		ic.methodA();
		ic.methodB(3);
		ic.new C().aaa.outA();
	}
}
