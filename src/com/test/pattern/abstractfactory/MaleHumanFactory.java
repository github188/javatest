package com.test.pattern.abstractfactory;

/**
 * �����������������
 * @author �ų�
 * 2012-7-30����04:52:53
 *
 */
public class MaleHumanFactory extends AbstractHumanFactory {

	@Override
	public Human createBlackHuman() {
		return super.createHuman(HumanEnum.BlackMaleHuman);
	}

	@Override
	public Human createWhiteHuman() {
		return super.createHuman(HumanEnum.WhiteMaleHuman);
	}

	@Override
	public Human createYellowHuman() {
		return super.createHuman(HumanEnum.YellowMaleHuman);
	}

}
