package com.test.pattern.command;

public class RecieverImpl implements Reviever {

	@Override
	public void action(String orderName) {
		System.out.println(orderName+"__����ʵʩ�߸ɻ���������");

	}

}
