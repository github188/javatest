package com.test.thread.threadMethodTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * wait/notify��ʽ
 * @author �ų�
 * 2012-7-26����05:10:45
 *
 */
public class ThreadMethodForWaitAndNotify {

	public static void main(String[] args) {
		ThreadMethodForWaitAndNotify t = new ThreadMethodForWaitAndNotify();
		// �����������ʵ��˻�
		MyCountTest myCount = new MyCountTest("95599200901215522", 100);
		// ����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Thread t1 = new SaveThreadTest("����", myCount, 2000);
		Thread t2 = new SaveThreadTest("����", myCount, 100);
		Thread t3 = new DrawThreadTest("����", myCount, 2700);
		Thread t4 = new SaveThreadTest("����", myCount, 600);
		Thread t5 = new SaveThreadTest("��ţ", myCount, 4000);
		Thread t6 = new DrawThreadTest("����", myCount, 800);
		// ִ�и����߳�
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		// �ر��̳߳�
		pool.shutdown();
	}
}

/**
 * ����߳���
 */
class SaveThreadTest extends Thread {
	private String name; // ������
	protected MyCountTest myCount; // �˻�
	private int x; // �����

	SaveThreadTest(String name, MyCountTest myCount, int x) {
		this.name = name;
		this.myCount = myCount;
		this.x = x;
	}

	public void run() {
		myCount.saving(x, name);
	}
}

/**
 * ȡ���߳���
 */
class DrawThreadTest extends Thread {
	private String name; // ������
	private MyCountTest myCount; // �˻�
	private int x; // �����

	DrawThreadTest(String name, MyCountTest myCount, int x) {
		this.name = name;
		this.myCount = myCount;
		this.x = x;
	}

	public void run() {
		myCount.drawing(x, name);
	}
}

/**
 * ��ͨ�����˻�������͸֧
 */
class MyCountTest {
	private String oid; // �˺�
	private int cash; // �˻����

	MyCountTest(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	/**
	 * ���
	 * 
	 * @param x
	 *            �������
	 * @param name
	 *            ������
	 */
	public synchronized void saving(int x, String name) {
		if (x > 0) {
			cash += x; // ���
			System.out.println(name + "���" + x + "����ǰ���Ϊ" + cash);
		}
		notifyAll(); // �������еȴ��̡߳�
	}

	/**
	 * ȡ��
	 * 
	 * @param x
	 *            �������
	 * @param name
	 *            ������
	 */
	public synchronized void drawing(int x, String name) {
		while(cash - x < 0) {
			try {
				System.out.println(name+"ȡ��ʧ�ܣ����㣡");
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} 
		cash -= x; // ȡ��
		System.out.println(name + "ȡ��" + x + "����ǰ���Ϊ" + cash);
		notifyAll(); // �������д�����
	}
}