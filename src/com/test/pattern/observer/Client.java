package com.test.pattern.observer;

import java.util.List;

import com.utils.ClassUtils;

public class Client {

	public static void main(String[] args) {
		//�����ӣ����۲�
		HanFeiZi hanfeizi = new HanFeiZi();
		
		//��˹�۲���
		Observer lisi = new LiSi();
		Observer wangsi = new WangSi();

		//�������Ժ���ӹ۲��߾Ͳ��øĶ�client�ˡ�
		List<Class> observers = ClassUtils.getAllSubClassesOrInterfaceImplementsClasses(Observer.class);
		for(Class o : observers){
			try {
				hanfeizi.addObserver((Observer)o.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		//hanfeizi.addObserver(lisi);
		//hanfeizi.addObserver(wangsi);
		
		hanfeizi.haveBreakfast();
		hanfeizi.haveFun();
	}

}
