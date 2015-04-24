package com.test.pattern.decorater;

public class Client {

	public static void main(String[] args) {
		//ԭʼ���꼶�ɼ���
		SchoolReport sr = new ForthGrateReport();
		
		//������߷�˵���ĳɼ���
		sr = new HighScoreDecorator(sr);
		
		//��������˵���ĳɼ���
		sr = new SortDecorator(sr);
		
		sr.report();
		sr.sign("�ϰ�");

	}
}
