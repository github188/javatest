package com.test.pattern.LSP;

public class ToyGunExtendsAbstractToyGun extends AbstractToyGun {

	public ToyGunExtendsAbstractToyGun(AbstractGun gun) {
		super.setGun(gun);
	}

	@Override
	public void shoot() {
		System.out.println("���ǹ�����ˮ����������");
		
	}
	
}
