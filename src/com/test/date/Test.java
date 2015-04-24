package com.test.date;

import java.util.GregorianCalendar;
/**
 * Ϊʲô year%4��Ч������year&3�أ�3��2����Ϊ11�����Ϻ���λ��Ϊ0�����֣������Ϊ0������Ч��һ��
 * ���������ٶȽϿ졣
11
100
101
110
111
1000
1001
1010
1011
1100
1101
1110
1111
10000
 * 
 * @author �ų�
 * 2012-4-26����04:39:22
 *
 */
public class Test {

	public static boolean isLeapYear(int year){
		if(year<1582){
			return false;
		}
		return (year%400 == 0)||(year%100 != 0) &&((year & 3)==0);
	}
	
	
	public static void main(String[] args) {
		int year = 2004;
		System.out.println(new GregorianCalendar().isLeapYear(year));
		System.out.println(isLeapYear(year));
	}
}
