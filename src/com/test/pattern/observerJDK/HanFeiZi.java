package com.test.pattern.observerJDK;

import java.util.Observable;

/**
 * Observable�����ѹ۲����б�����ɾ��֪ͨ�Ȳ������� �ˡ�
 * @author �ų�
 * 2012-7-31����11:06:03
 *
 */
public class HanFeiZi extends Observable{

	public void haveBreakfast(){
		System.out.println("������:������Ҫ�Է���");
		this.setChanged();
		this.notifyObservers("������Ҫ�Է���");
	}
	
	public void haveFun(){
		System.out.println("�����ӣ���������ȥ����¥��");
		this.setChanged();
		this.notifyObservers("��������ȥ����¥��");
	}
}
