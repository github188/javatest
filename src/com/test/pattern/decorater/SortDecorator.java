package com.test.pattern.decorater;

public class SortDecorator extends Decorator{

	public SortDecorator(SchoolReport sr) {
		super(sr);
	}

	@Override
	public void report() {
		sortReport();
		super.report();
	}

	private void sortReport(){
		System.out.println("��β�����30��");
	}
	
}
