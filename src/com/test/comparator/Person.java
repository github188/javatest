package com.test.comparator;
/**
 * �����û�ж�age���бȽϲ�����Ҳû�ж���Ƚ���������sort()����ʱ���ᰴ����Ȼ����
 * @author �ų�
 * 2012-2-24����11:28:12
 *
 */
public class Person {

	private int age;
	private String firstName;
	private String lastName;

	public Person(int age, String firstName, String lastName) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Person)) {
			return false;
		}
		Person p = (Person) o;
		return (age == p.getAge()) && (firstName.equals(p.getFirstName()))
				&& (lastName.equals(p.getLastName()));
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + firstName.hashCode();
		result = 37 * result + lastName.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return age + " {" + firstName + " }" + "{ " + lastName + " }";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
