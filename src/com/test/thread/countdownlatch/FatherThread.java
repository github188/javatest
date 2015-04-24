package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * �������̵߳ȴ��������߳�ִ�е�ĳ��
 * @author �ų�
 *
 * Apr 18, 2013
 */
public class FatherThread implements Runnable{

	private int LOOP_SIZE=5;
	final CountDownLatch threadSize = new CountDownLatch(LOOP_SIZE);
	
	@Override
	public void run() {
		excute();
		try {
			threadSize.await();//���û�еȴ�����ô��ֱ�ӽ����ˣ����ֲ������̵߳ȴ���5�롣
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ִ�н�����");
	}


	private void excute() {
		for(int i =LOOP_SIZE;i>0;i--){
			Thread childThread = new Thread(i+""){

				@Override
				public void run() {
					System.out.println("���̷߳���ִ��----"+this.getName());
					try {
						Thread.sleep(5000);//Ϊ������Ч�����������������߳�˯��5�롣
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					threadSize.countDown();
				}
			};
			childThread.start();
			System.out.println("���߳̿�ʼ��----"+childThread.getName());
		}
	}

	public static void main(String[] args) {
		FatherThread ft = new FatherThread();
		new Thread(ft).start();
	}
	
	
	
	
}
