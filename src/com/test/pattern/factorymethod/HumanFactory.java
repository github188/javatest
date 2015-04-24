package com.test.pattern.factorymethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.utils.ClassUtils;

/**
 * ��������ģʽ
 * @author �ų�
 * 2012-7-30����02:40:41
 *
 */
public class HumanFactory {

	//�����ӳ�ʼ��
	private static Map<String,Human> humans= new HashMap<String,Human>();
	/**
	 * �������󷽷�
	 * @param c ��
	 * @return
	 */
	public static Human createHuman(Class c) {
		
		Human human = null;
		try {
			if(humans.containsKey(c.getSimpleName())){
				human = humans.get(c.getSimpleName());
			}else{
				human = (Human) Class.forName(c.getName()).newInstance();
				humans.put(c.getSimpleName(), human);
			}
		} catch (InstantiationException e) {
			System.out.println("����ָ��������ɫ��");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("���ඨ�����");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("�쵰����ָ�� �������Ҳ�����");
			e.printStackTrace();
		}
		return human;
	}
	
	//��������������
	public static Human createHumanRandom(){
		Human human = null;
		List<Class> humanImplementsList = ClassUtils.getAllSubClassesOrInterfaceImplementsClasses(Human.class);//�õ�ʵ����human�ӿڵ���
		Random rand = new Random();
		int randInt = rand.nextInt(humanImplementsList.size());
		human = createHuman(humanImplementsList.get(randInt));
		return human;
	}
	
}
