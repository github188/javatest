package com.test.pattern.factorymethod;

public class BlackHuman implements Human {

	@Override
	public void cry() {
		System.out.println("��ɫ�˻��");

	}

	@Override
	public void laugh() {
		System.out.println("��ɫ�˻�Ц");

	}

	@Override
	public void talk() {
		System.out.println("��ɫ�˻ὲ��");
	}

}
