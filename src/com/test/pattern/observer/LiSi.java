package com.test.pattern.observer;

public class LiSi implements Observer {

	@Override
	public void update(String context) {
		System.out.println("��˹֪���ˣ�"+context);
		toQinShiHuang(context);
	}
	
	public void toQinShiHuang(String context){
		System.out.println("��ʼ��֪���ˣ�"+context);
	}
	

}
