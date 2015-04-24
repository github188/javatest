package com.test.pattern.templatemethod;

public class HummerModel1 extends Template {
	private boolean isAlarm = true;

	@Override
	protected boolean isAlarm() {
		return isAlarm;
	}

	//�Ϳ��Ƿ���Ҫ�������ⲿ�����ˣ������Ҫ�����һ��set������
	public void setAlarm(boolean isAlarm){
		this.isAlarm = isAlarm;
	}

	@Override
	protected void alarm() {
		System.out.println("HummerModel��������");

	}

	@Override
	protected void start() {
		System.out.println("HummerModel����������");

	}

	@Override
	protected void stop() {
		System.out.println("HummerModel����ֹͣ��");

	}

}
