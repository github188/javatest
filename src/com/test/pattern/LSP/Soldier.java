package com.test.pattern.LSP;

public class Soldier {

	public void killEnemys(AbstractGun gun){
		System.out.println("ʿ����ʼɱ����");
		gun.shape();
		gun.shoot();
	}
	
	public void playGame(AbstractToyGun gun){
		System.out.println("ʿ����ɱ����Ϸ��");
		gun.shape();
		gun.shoot();
	}
	
}
