package com.test.thiss;

//���ض���������ã����������ǳ���Ȥ�����顣
public class ReturnThis {

	int i;
	public ReturnThis increment(){
		i++;
		return this;
	}
	
	public static void main(String[] args) {
		System.out.println(new ReturnThis().increment().increment().increment().i);
	}
}
/*output:3
 *///:~
