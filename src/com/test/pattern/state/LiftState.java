package com.test.pattern.state;
/**
 * ���ݵ�״̬�ӿ�(һ��5�����ڵ�״̬������״̬ģʽ�����״̬̫��ᵼ��������ǣ�����Ŷ��)
 * @author �ų�
 * 2012-8-2����02:03:35
 *
 */
public abstract class LiftState {
	
	//��װ����״̬�������Ĺ��ܱ仯
	protected Context context;

	public void setContext(Context context) {
		this.context = context;
	}
	
	public abstract void open();

	public abstract void close();

	public abstract void run();

	public abstract void stop();
}
