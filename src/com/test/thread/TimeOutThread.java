package com.test.thread;

	/**
	 *���߳�������һ����ʱʱ��
	 * ���߳̿�ʼ���к󾭹�ָ����ʱʱ��
	 * ���̻߳��׳�һ��δ����쳣֪ͨ���ø��̵߳ĳ���ʱ
	 * �ڳ�ʱ����ǰ���Ե��ø����cancel����ȡ����ʱ
	 * @author �ų�
	 *
	 * Jan 20, 2014
	 */
	public class TimeOutThread extends Thread{
	/**
	* ��ʱ����ʱʱ��
	*/
	private long timeout;
	/**
	* ��ʱ�Ƿ�ȡ��
	*/
	private boolean isCanceled = false;
	/**
	* ����ʱ����ʱʱ�׳����쳣
	*/
	private TimeOutException timeoutException;
	/**
	* ������
	* @param timeout ָ����ʱ��ʱ��
	*/
	public TimeOutThread(long timeout,TimeOutException timeOutException) {
		super();
		this.timeout = timeout;
		this.timeoutException = timeOutException;
		//���ñ��߳�Ϊ�ػ��߳�
		
		this.setDaemon(true);
	}
	
	/**
	* ȡ����ʱ
	*/
	public synchronized void cancel()
	{
		isCanceled = true;
	}
	/**
	* ������ʱ��ʱ��
	*/
	public void run()
	{
		try {
			Thread.sleep(timeout);
			if(!isCanceled)
			{
				throw timeoutException;
			}
		}catch (TimeOutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}