package com.test.thread;

public class MainThreadTimeOut {

	public static void main(String[] args) {
		
		TimeOutThread t = new TimeOutThread(5000,new TimeOutException("��ʱ"));
		try{
			t.start();
			//.....Ҫ��ⳬʱ�ĳ����....
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.cancel();
		}catch (TimeOutException e)
		{
			//...�Գ�ʱ�Ĵ���...
			System.out.println(e.getMessage());
		}
	}

}
