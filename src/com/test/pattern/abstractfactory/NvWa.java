package com.test.pattern.abstractfactory;

public class NvWa {

	public static void main(String[] args) {
		//����������
		HumanFactory maleFactory = new MaleHumanFactory();
		//Ů��������
		HumanFactory femaleFactory = new FemaleHumanFactory();
		
		
		Human maleBlackHuman = maleFactory.createBlackHuman();
		
		Human femaleBlackHuman = femaleFactory.createBlackHuman();
		
		maleBlackHuman.cry();
		maleBlackHuman.laugh();
		maleBlackHuman.talk();
		maleBlackHuman.sex();
		
		femaleBlackHuman.cry();
		femaleBlackHuman.laugh();
		femaleBlackHuman.talk();
		femaleBlackHuman.sex();

	}

}
