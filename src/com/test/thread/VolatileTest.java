package com.test.thread;

public class VolatileTest extends Thread{

	private static volatile int n = 0;

	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				inc();
				sleep(3); // Ϊ��ʹ���н����������ӳ�3����

			} catch (Exception e) {
		}
	}

	private static synchronized void inc(){//����static�Ͳ���??why???
		n++;
	}
	
	public static void main(String[] args) throws Exception {

		Thread threads[] = new Thread[100];
		for (int i = 0; i < threads.length; i++)
			// ����100���߳�
			threads[i] = new VolatileTest();
		for (int i = 0; i < threads.length; i++)
			// ���иղŽ�����100���߳�
			threads[i].start();
		for (int i = 0; i < threads.length; i++)
			// 100���̶߳�ִ��������
			threads[i].join();
		
		System.out.println(VolatileTest.n);
		
	}
}
