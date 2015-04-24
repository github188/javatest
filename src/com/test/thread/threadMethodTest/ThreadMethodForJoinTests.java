package com.test.thread.threadMethodTest;


public class ThreadMethodForJoinTests {
	
	
	public ThreadMethodForJoinTests() {
	}

	class ThreadTestForJoinMethod extends Thread{
		@Override
		public void run() {
			for(int i=1;i<10;i++){
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadTestForJoinMethod t = new ThreadMethodForJoinTests().new ThreadTestForJoinMethod();
		t.start();
		try {
			//t.join();//һֱ�ȴ��߳�tִ����ɣ��ż���ִ�����̡߳�
			t.join(3000);//�ȴ�3�룬�����߳�t��û��ִ���꣬������ִ�����̡߳�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread is done!");
	}

}
