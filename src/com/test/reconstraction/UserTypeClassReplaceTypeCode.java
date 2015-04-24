package com.test.reconstraction;

/**
 * �����Ͷ���ȡ�������룬���ع�������
 * �ڴ��ε�ʱ���� UserTypeClassReplaceTypeCode.TRAFFIC_STATUS_1������Ҫʹ���������͵�ʱ����TRAFFIC_STATUS_1.getCode()
 * @author �ų�
 * 2012-7-27����05:23:41
 *
 */
public class UserTypeClassReplaceTypeCode {

	private String code;

	private UserTypeClassReplaceTypeCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	/**
	 * ����ӵ��
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_1 = new UserTypeClassReplaceTypeCode(
			"1");
	/**
	 * �ж�ӵ��
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_2 = new UserTypeClassReplaceTypeCode(
			"2");
	/**
	 * ���ӵ��
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_3 = new UserTypeClassReplaceTypeCode(
			"3");
	/**
	 * ������ͨ
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_4 = new UserTypeClassReplaceTypeCode(
			"4");
	/**
	 * ��ͨ
	 */
	public static final UserTypeClassReplaceTypeCode TRAFFIC_STATUS_5 = new UserTypeClassReplaceTypeCode(
			"5");

	public static UserTypeClassReplaceTypeCode createByCode(String code) {
		if (code.equals(TRAFFIC_STATUS_1.getCode())) {
			return TRAFFIC_STATUS_1;
		}

		if (code.equals(TRAFFIC_STATUS_2.getCode())) {
			return TRAFFIC_STATUS_2;
		}

		if (code.equals(TRAFFIC_STATUS_3.getCode())) {
			return TRAFFIC_STATUS_3;
		}

		if (code.equals(TRAFFIC_STATUS_4.getCode())) {
			return TRAFFIC_STATUS_4;
		}

		if (code.equals(TRAFFIC_STATUS_5.getCode())) {
			return TRAFFIC_STATUS_5;
		}
		throw new RuntimeException("������" + code + "����");
	}
}
