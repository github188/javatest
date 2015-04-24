package com.test.comparable;
/**
 * �����û�ж�name���бȽϲ�����Ҳû�ж���Ƚ���������sort()����ʱ���ᰴ����Ȼ����
 * @author �ų�
 * 2012-2-24����11:33:14
 *
 */
public class Person implements Comparable<Person> {

	/** ���������ԱȲ��� **/
	private int age;
	private String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		int result = age - o.getAge();
		if (result != 0) {
			return result;// ��һ���Աȶ���age
		} else {
			return name.compareTo(o.name);// �����һ������ȣ���ȶԵڶ���
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Person)) {
			return false;
		}
		Person p = (Person) o;
		return (age == p.getAge()) && (name.equals(p.getName()));
	}
	
	/**Object��hashCode�������ص��Ƕ�����ڴ��ַ**/
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + age;
		result = 37 * result + name.hashCode();
		return result;
	}

	public String toString() {
		return age + "{ " + name + " }";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
