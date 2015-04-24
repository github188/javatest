package com.test.gc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * ���һ������û���˱����ã���ô���ܱ��������ջ����ա�
 * @author �ų�
 * 2012-7-27����11:32:41
 *
 */
public class GCTest {

	private List<String> paramsList = null;
	@Before
	public void setUp(){
		paramsList = new ArrayList<String>();
		paramsList.add("a");
		paramsList.add("b");
		paramsList.add("c");
		paramsList.add("d");
		paramsList.add("e");
	}
	
	@Test
	public void strongReference(){
		String str = "hello";//��һ�䣬���ȴ�����"hello"�������Ȼ��str������"hello"����ĵ�ַ��
		String newStr = str;//newStr�������������str�����õĵ�ַ��ֻ�Ǹ���������,��û�и��ƶ���
		str=null;
		//System.gc();
		assertNotNull(newStr);
		assertNull(str);
	}
	
	@Test
	public void paramObjectTests(){
		assertEquals(paramsList, removeOneObject(paramsList));
		System.out.println(paramsList);//[b, c, d, e]
		
		assertNull(setNull(paramsList));
		assertNotNull(paramsList);
		
		assertEquals(paramsList, removeOneObject2(paramsList));
		System.out.println(paramsList);//[c, d, e]
	}
	
	public List<String> removeOneObject(List<String> list){
		List<String> data =list;
		data.remove(0);
		return data;
	}
	
	public List<String> setNull(List<String> list){
		List<String> data =list;
		data=null;
		return data;
	}
	
	public List<String> removeOneObject2(List<String> list){
		list.remove(0);
		return list;
	}
}
