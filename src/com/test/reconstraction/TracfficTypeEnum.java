package com.test.reconstraction;

/**
 * ö�����ͣ�ʵ�������Ͷ���ȡ�������룬���ع�������
 * @author �ų�
 * 2012-7-30����05:35:51
 *
 */
public enum TracfficTypeEnum {

	traffic_1("1"),
	traffic_2("1"),
	traffic_3("3");
	
	private String value="";

	private TracfficTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public TracfficTypeEnum createTypeClassByCode(String value){
		if(value.equals(traffic_1.getValue())){
			return traffic_1;
		}
		if(value.equals(traffic_2.getValue())){
			return traffic_2;
		}
		if(value.equals(traffic_3.getValue())){
			return traffic_3;
		}
		throw new RuntimeException("������"+value+"����");
	}
}
