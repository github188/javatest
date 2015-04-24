package com.test.pattern.abstractfactory;

public abstract class AbstractHumanFactory implements HumanFactory{

	/**
	 * ����һ���Ա����࣬����һ�����������רҵ����в�Ʒ�ȼ�
	 * @param humanEnum
	 * @return
	 */
	public Human createHuman(HumanEnum humanEnum){
		Human human = null;
		if(!humanEnum.getValue().equals("")){
			try {
				human = (Human) Class.forName(humanEnum.getValue()).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return human;
	}
}
