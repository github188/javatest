package com.test.pattern.factorymethod;

public class WhiteHuman implements Human {

	@Override
	public void cry() {
		System.out.println("�����ڿ�");

	}

	@Override
	public void laugh() {
		System.out.println("������Ц");

	}

	@Override
	public void talk() {
		System.out.println("�����ڽ���");

	}

}
