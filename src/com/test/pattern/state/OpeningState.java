package com.test.pattern.state;

public class OpeningState extends LiftState {

	//�ڿ��������ǿ��Թرյġ�
	@Override
	public void close() {
		super.context.setLiftState(Context.closeingState);
		super.context.getLiftState().close();

	}

	@Override
	public void open() {
		System.out.println("�����ſ�����");

	}

	@Override
	public void run() {
		// do nothing!

	}

	@Override
	public void stop() {
		// do nothing!

	}

}
