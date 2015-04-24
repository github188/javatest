package example;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Assert;
import org.junit.Test;

/**
 * �����߳��Ƿ��������
 */
public class TestBlockingBehavior {

	AtomicBoolean blocked = new AtomicBoolean(true);
	BlackMarket bm;
	@Test
    public void testBlockingBehavior() throws Exception {
        Thread buyer = new Thread() {
            @Override
            public void run() {
                try {
                	bm=new BlackMarket();
                	bm.buyTicket();
                	
                    blocked.set(false);
                    System.out.println("continue");
                    Assert.assertFalse("Method didn't block!", blocked.get());
                } catch (InterruptedException success) {
                	/**
                	 * ��Ҫע����ǣ�InterruptedException���߳��Լ����ڲ��׳��ģ�
                	 * ������interrupt()�����׳��ġ���ĳһ�̵߳���interrupt()ʱ��
                	 * ������߳�����ִ����ͨ�Ĵ��룬��ô���̸߳����Ͳ����׳�InterruptedException��
                	 * ���ǣ�һ�����߳̽��뵽wait()/sleep()/join()�󣬾ͻ������׳�InterruptedException�� 
                	 */
                	blocked.set(false);
                	System.out.println("exception"+success.getMessage());
                }
            }
        };
        buyer.start();
        Thread.sleep(1000);
        //buyer.join(1000);
        //buyer.interrupt();
        Assert.assertTrue("Thread didn't interrupt!", buyer
                .isAlive());
        Assert.assertTrue("Method didn't block!", blocked.get());
        
        bm.setBlock(false);
        
    }

	class BlackMarket{
		private boolean blocked=true;
		private synchronized void buyTicket() throws InterruptedException{
			while(blocked){
				System.out.println("wait");
				wait();
			}
		}
		private synchronized void setBlock(boolean blocked){
			this.blocked=blocked;
			notify();
		}
	}
	
}
