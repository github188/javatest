package com.test.pattern.observerJDK;

import java.util.Observable;
import java.util.Observer;

public class LiSi implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("��˹֪����"+arg.toString());
		toQinShiHuang(arg.toString());
	}
	
	public void toQinShiHuang(String context){
		System.out.println("��ʼ��֪���ˣ�"+context);
	}

}
