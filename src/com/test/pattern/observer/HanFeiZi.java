package com.test.pattern.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * ������������۲���
 * @author �ų�
 * 2012-7-31����10:38:29
 *
 */
public class HanFeiZi implements Observable {

	private List<Observer> observers = new ArrayList<Observer>();
	
	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);

	}

	@Override
	public void deleteObserver(Observer o) {
		this.deleteObserver(o);

	}

	@Override
	public void notifyAllObservers(String context) {
		for(Observer o : observers){
			o.update(context);
		}
	}
//--------------------------------------------------------------------------
	public void haveBreakfast(){
		System.out.println("������:������Ҫ�Է���");
		this.notifyAllObservers("������Ҫ�Է���");
		
	}
	
	public void haveFun(){
		System.out.println("�����ӣ���������ȥ����¥��");
		this.notifyAllObservers("������ȥ����¥��");
	}
	
}
