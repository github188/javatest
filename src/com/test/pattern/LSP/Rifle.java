package com.test.pattern.LSP;

public class Rifle extends AbstractGun {

	@Override
	public void shoot() {
		System.out.println("��ǹ��ʼ�����");

	}

	@Override
	public void shape() {
		System.out.println("��ǹ����״����");
		
	}

}
