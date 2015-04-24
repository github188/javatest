package com.test.thread;

/**
 * ThreadLocal<T>�̵߳ľֲ���������Щ������ͬ�����ǵ���ͨ��Ӧ�
 * ��Ϊ����ĳ��������ͨ���� get �� set ��������ÿ���̶߳����Լ��ľֲ��������������ڱ����ĳ�ʼ��������(�ٷ�����)
 * 
 * ��ÿ���߳���˵���൱�ڰ�ͬһ�������Ƹ���ÿһ���̣߳������̶߳��ж����Ķ���������ʹ��Ȩ���������ţ��͸����б���һ����
 * �������±ߴ����е�x��
 * �Ҿ���ThreadLocal�����þ��ǣ������߳���Ϊkey����ThreadLocal��ʵ��ֵ��Ϊvalue��������map�У���ÿ���߳���˵����get�������ܻ�ȡ���Լ���
 * �Ǹ�����ʡȥ�˲������ݵ��鷳��Hibernate�е�session����õ����ӡ�
 	private static final ThreadLocal threadSession = new ThreadLocal();

    public static Session getSession() throws InfrastructureException {
        Session s = (Session) threadSession.get();
        try {
            if (s == null) {
                s = getSessionFactory().openSession();
                threadSession.set(s);
            }
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
        return s;
    }
	�������ôд������session��Ҫ��service��һ�������ݵ�dao�㡣
 * @author �ų�
 *
 * Mar 14, 2013
 */
public class ThreadLocalTest {

	private static final ThreadLocal<Integer> uniqueNum = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			return 0;
		}
		
	};
	
	private static Integer getGenerateId(){
		uniqueNum.set(uniqueNum.get()+1);
		return uniqueNum.get();
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			private int x=1;
			@Override
			public void run() {
				for(int i=0;i<3;i++){
					System.out.println(this.getName()+":"+getGenerateId()+"__"+x++);
				}
			}
			
		};
		Thread t2 = new Thread(){
			private int x=1;
			@Override
			public void run() {
				for(int i=0;i<3;i++){
					System.out.println(this.getName()+":"+getGenerateId()+"__"+x++);
				}
			}
			
		};
		
		t1.start();
		t2.start();
		
	}

}
/*output:
Thread-0:1__1
Thread-1:1__1
Thread-0:2__2
Thread-1:2__2
Thread-0:3__3
Thread-1:3__3*///:~
