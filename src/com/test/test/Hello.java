package com.test.test;

public class Hello{
	public static void main(String args[ ]){
		
		
	}	
	/**
	 * 1:������0:ʧ��;-1:�쳣
	 * @return
	 */
	public int excute(){
		try{
			if(true){
				return 1;
			}else{
				return 0;
			}
		}catch(Exception e){
			return -1;
		}
	}
	
	public void excute2(){
		try{
			System.out.println("execute");
		}catch(Exception e){
			throw new RuntimeException("������"+e);
		}
	}
}
