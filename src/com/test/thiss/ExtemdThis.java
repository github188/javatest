package com.test.thiss;

//this������
/*�����˵����2�����⣬һ����this��������һ���Ǵ�����������ʱ�򣬱�Ȼ�ȴ����������
 * ����this(1)������ǰ��Ĭ�ϲ�����һ��super();
 * ��IDE���ɹ�������ʱ����Զ����룬��֪�����ע���û�С�*/
public class ExtemdThis extends Father{

	int x;
	
	public ExtemdThis() {
		this(1);//���ֵ��ñ����ڴ˷����еĵ�һ�������򱨴�
		super.p();
	}
	
	public ExtemdThis(int x) {
		this.x = x;
	}
	
	public static void main(String[] args) {
		System.out.println(new ExtemdThis().x);
	}
}

class Father{
	protected void p(){
		System.out.println("Father");
	}
}
/*
Father
1
*///:~