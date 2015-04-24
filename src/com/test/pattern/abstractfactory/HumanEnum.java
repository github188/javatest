package com.test.pattern.abstractfactory;

/**
 * ����������
 * @author �ų�
 * 2012-7-30����04:41:53
 *
 */
public enum HumanEnum {

	YellowMaleHuman("com.test.pattern.abstractfactory.YellowMaleHuman"),
	
	YellowFemaleHuman("com.test.pattern.abstractfactory.YellowFemaleHuman"),
	
	BlackMaleHuman("com.test.pattern.abstractfactory.BlackMaleHuman"),
	
	BlackFemaleHuman("com.test.pattern.abstractfactory.BlackFemaleHuman"),
	
	WhiteMaleHuman("com.test.pattern.abstractfactory.WhiteMaleHuman"),
	
	WhiteFemaleHuman("com.test.pattern.abstractfactory.WhiteFemaleHuman");
	
	
	
	private String value="" ;

	private HumanEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
