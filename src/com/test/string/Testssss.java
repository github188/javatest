package com.test.string;

public class Testssss {

	public static void main(String[] args) {
		char a =1;
		String resultBinaryString = Integer.toBinaryString(a);
		
		while(resultBinaryString.length()<2){
			resultBinaryString="0"+resultBinaryString;//����õ���2����8�ֽ���ǰ�ߵ�0������1,����Ϊ01
		}
		System.out.println(resultBinaryString);
	}

}
