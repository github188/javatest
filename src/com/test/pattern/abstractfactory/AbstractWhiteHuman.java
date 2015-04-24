package com.test.pattern.abstractfactory;

public abstract class AbstractWhiteHuman implements Human {

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