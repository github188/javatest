package com.test.pattern.abstractfactory;

public abstract class AbstractYellowHuman implements Human {

	@Override
	public void cry() {
		System.out.println("��ɫ�˻��");

	}

	@Override
	public void laugh() {
		System.out.println("��ɫ�˻��Ц");

	}

	@Override
	public void talk() {
		System.out.println("��ɫ�˻ὲ��");

	}
}
