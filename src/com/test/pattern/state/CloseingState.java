package com.test.pattern.state;

public class CloseingState extends LiftState {

	@Override
	public void close() {
		System.out.println("�����ڹ����ˣ�");

	}

	//���ź�Ȼ���Դ�
	@Override
	public void open() {
		super.context.setLiftState(Context.openningState);
		super.context.getLiftState().open();
	}

	//���ź����������
	@Override
	public void run() {
		super.context.setLiftState(Context.runningState);
		super.context.getLiftState().run();

	}

	//�൱�ڹ��ź���һֱ�����У���Ҷ�֪����
	@Override
	public void stop() {
		super.context.setLiftState(Context.stoppingState);
		super.context.getLiftState().stop();

	}

}
