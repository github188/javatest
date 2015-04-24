package com.test.gc;
/*
 * finalize����ֻ����������µ��ã�һ����jvm׼���������գ����ȵ����������о����ֶ�����System.gc()��������
 * ������������ֻ���ڴ��й�ϵ��ֻ���ڴ治���õ�ʱ��Ż�ִ�л��ջ��ƣ���finalize���߽�����Ӧ����Ϊnull��ֻ��˵��
 * �˶�����Ա����գ�����һ���ͻᱻ���ա�
 * ����������Ϊnullֻ���ͷ�����ջ�е��ڴӣ���û���ͷ��ڶ���new���ڴ棬���е��ڴ���jvm�������տ��ơ�
 */
public class FinalizeTest {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize called");
	}
	
	public static void main(String[] args) {
		new FinalizeTest();
		System.gc();
		System.gc();
	}
}
/*output:finalize called*///:~
