package com.test.pattern.templatemethod;

/**
 * ģ�巽��ģʽ����ģ�巽���а���һ�������˳��ִ�л������������ҿ�����isAlarm��������ִ��˳��ı����
 * @author �ų�
 * 2012-7-31����04:22:50
 *
 */
public abstract class Template {

	//��������
	protected abstract void start();
	//��������
	protected abstract void alarm();
	//��������
	protected abstract void stop();


	//ģ�巽��
	public void run() {
		this.start();
		//���ӣ�ͨ��������дisAlarm���������Դﵽ������Ƿ�ִ����δ��롣
		if (this.isAlarm()) {
			this.alarm();
		}
		this.stop();
	}

	//���ӷ���
	protected boolean isAlarm() {
		return true;
	}


}
