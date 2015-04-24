package com.test.pattern.abstractfactory;

/**
 * Ů����������
 * @author �ų�
 * 2012-7-30����04:55:14
 *
 */
public class FemaleHumanFactory extends AbstractHumanFactory {

	@Override
	public Human createBlackHuman() {
		return super.createHuman(HumanEnum.BlackFemaleHuman);
	}

	@Override
	public Human createWhiteHuman() {
		return super.createHuman(HumanEnum.WhiteFemaleHuman);
	}

	@Override
	public Human createYellowHuman() {
		return super.createHuman(HumanEnum.YellowFemaleHuman);
	}

}
