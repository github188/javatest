package com.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectUtil {

	/**
	 * ��������������������ʵ��
	 * 
	 * @param className
	 *            ����
	 * @param args
	 *            ����
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Object getInstance(String className, Object[] args)
			throws Exception {
		Class<?> clas = Class.forName(className);
		Class[] argsClass = new Class[args.length];
		for (int i = 0; i < argsClass.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Constructor con = clas.getConstructor(argsClass);
		return con.newInstance();
	}

	/**
	 * ͨ�����������������ȡ����ֵ
	 * 
	 * @param owner
	 *            ����
	 * @param fieldName
	 *            ������
	 * @return
	 * @throws Exception
	 */
	public static Object getProperty(Object owner, String fieldName)
			throws Exception {
		Class<?> ownerClass = owner.getClass();
		Field field = ownerClass.getDeclaredField(fieldName);
		field.setAccessible(true);// ����ͨ��������ʸ�Fieldʱȡ������Ȩ�޼�飬�����Ϳ��Է���˽�������ˡ�
		Object property = field.get(owner);
		return property;
	}

	/**
	 * ִ��ĳ��ķ���
	 * 
	 * @param owner
	 *            �����
	 * @param methodName
	 *            ������
	 * @param args
	 *            ����
	 * @return
	 * @throws Exception
	 */
	public static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {
		Class<?> ownerClass = owner.getClass();
		Class[] argsClass = new Class[args.length];
		for (int i = 0; i < argsClass.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
		return method.invoke(owner, argsClass);

	}

	/**
	 * ִ��ĳ��ľ�̬����
	 * 
	 * @param className
	 *            ����
	 * @param methodName
	 *            ������
	 * @param args
	 *            ����
	 * @return
	 * @throws Exception
	 */
	public static Object invokeStaticMethod(String className,
			String methodName, Object[] args) throws Exception {
		Class<?> ownerClass = Class.forName(className);
		Class[] argsClass = new Class[args.length];
		for (int i = 0; i < argsClass.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
		return method.invoke(null, argsClass);

	}

	/**
	 * �ж��ǲ���ĳ�����ʵ��
	 * 
	 * @param obj
	 *            ʵ��
	 * @param clas
	 *            ��
	 * @return
	 */
	public static boolean isInstance(Object obj, Class<?> clas) {
		return clas.isInstance(obj);
	}

	/**
	 * ����һ�����������Ǵ˶������javabean�淶
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public Object copy(Object object) throws Exception {
		// ��ö��������
		Class<?> classType = object.getClass();
		System.out.println("Class:" + classType.getName());

		// ͨ��Ĭ�Ϲ��췽������һ���µĶ���
		Object objectCopy = classType.getConstructor(new Class[] {})
				.newInstance(new Object[] {});

		// ��ö������������
		Field fields[] = classType.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			// ��ú����Զ�Ӧ��getXXX()����������
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			// ��ú����Զ�Ӧ��setXXX()����������
			String setMethodName = "set" + firstLetter + fieldName.substring(1);

			// ��ú����Զ�Ӧ��getXXX()����
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			// ��ú����Զ�Ӧ��setXXX()����
			Method setMethod = classType.getMethod(setMethodName,
					new Class[] { field.getType() });

			// ����ԭ�����getXXX()����
			Object value = getMethod.invoke(object, new Object[] {});
			System.out.println(fieldName + ":" + value);
			// ���ÿ��������setXXX()����
			setMethod.invoke(objectCopy, new Object[] { value });
		}
		return objectCopy;
	}

	/**
	 * ��ȡ����������
	 * @param clas
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public Type getType(Class<?> clas ,String fieldName) throws Exception{
		Field field = clas.getDeclaredField(fieldName);
		Class<?> type = field.getType();//�õ���ͨ����
		Type gType = field.getGenericType();//�õ���������
		//����Ƿ�������
		if(gType instanceof ParameterizedType){
			ParameterizedType pType = (ParameterizedType)gType;
			Type rType = pType.getRawType();
			//Type[] tArgs = pType.getActualTypeArguments();//��ȡ���Ͳ�������
			return rType;
		}else{
			return type;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Person p = (Person) getInstance("com.test.reflect.Person",
				new Object[] {});
		p.setId("1");
		p.setName("charles");
		System.out.println(p.getName());

		System.out.println(getProperty(p, "name"));

	}
}
