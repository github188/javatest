package com.test.pattern.decorater;

public class ForthGrateReport implements SchoolReport{

	@Override
	public void report() {
		System.out.println("ԭʼ�ĳɼ���");
		
	}

	@Override
	public void sign(String name) {
		System.out.println("ǩ����"+name);
		
	}

}
