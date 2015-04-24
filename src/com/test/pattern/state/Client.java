package com.test.pattern.state;
/**
 * 
Ӧ�ó���
1����һ���������Ϊȡ��������״̬, ����������������ʱ�̸���״̬�ı�������Ϊ��
2��һ�������к����Ӵ�Ķ��֧��������䣬����Щ��֧�����ڸö����״̬��
���״̬ͨ����һ������ö�ٳ�����ʾ��ͨ��, �ж������������һ��ͬ�������ṹ��
Stateģʽ��ÿһ��������֧����һ�����������С���ʹ������Ը��ݶ������������������״̬��Ϊһ������
��һ������Բ���������������������仯��
 * @author �ų�
 * 2012-8-2����02:13:43
 *
 */
public class Client {

	public static void main(String[] args) {

		//����
		Context context = new Context();
		context.setLiftState(new OpeningState());
		
		//����״̬����
		context.open();
		context.close();
		context.run();
		context.stop();
		context.open();
		
		//�쳣״̬����
		context.open();
		context.run();
		
	}

}
