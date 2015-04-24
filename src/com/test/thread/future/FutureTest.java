package com.test.thread.future;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.Callable;

import org.junit.Test;


/**
 * ������һ���߳���Ҫʹ��ĳһ���̵߳Ľ��ʱ������ͨ��Future���õ�get()����ȥ��ã�
 * ��������δ���������ô˷������̱߳�block��ֱ�����������
 * �������ӣ���ʾ���У������ʱ�ˣ���ô�Ͳ���ִ��assertEquals(i, future.get(500,TimeUnit.MILLISECONDS));
 * ֱ��future.get(500,TimeUnit.MILLISECONDS)���˽�����ż���ִ�д��̡߳������߳������ִ�С�
 * @author �ų�  
 * 2012-7-25����05:18:54
 *
 */
public class FutureTest {

	@Test
	public void checkThreadIsDone(){
		ExecutorService es = Executors.newCachedThreadPool();
		Future<?> future=null;
		for(int i=1;i<10;i++){
			int timeOut = new Random().nextInt(10)*100;
			future = es.submit(new FutureTest().new ReturnResultThread(i,timeOut));
			try {
				assertEquals(i, future.get(500,TimeUnit.MILLISECONDS));
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				boolean result = timeOut-500>0?true:false;
				assertTrue(result);
				System.out.println(i+" outTime");
			}
		}
		
		System.out.println("mainThread");
		
	}
	
class ReturnResultThread implements Callable<Object>{

	private int num;
	private int timeOut;
	public ReturnResultThread(int num, int timeOut) {
		this.num = num;
		this.timeOut = timeOut;
	}

	@Override
	public Object call() throws Exception {
		Thread.sleep(timeOut);
		System.out.println(num+" is done "+timeOut);
		return num;
	}

	
}
	
	
}
