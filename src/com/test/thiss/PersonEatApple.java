package com.test.thiss;

//����ǰ���󴫵ݸ���������,Ϊ����ʾ�Ҳ����еĵ��ۣ��ڴ��ݹ����жԴ˶�������һЩ������x��ֵ��
public class PersonEatApple {

	public void eat(Apple apple){
		Apple peeled = apple.getPeeled();
		System.out.println(peeled.x);
	}
	
	public static void main(String[] args) {
		new PersonEatApple().eat(new Apple());
	}
}

class Peeler{
	static Apple peel(Apple apple){
		apple.x=1;
		return apple;
	}
}

class Apple{
	int x;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	Apple getPeeled(){
		return Peeler.peel(this);
	}
}
/*Output:
 * 1
 * *///:~
