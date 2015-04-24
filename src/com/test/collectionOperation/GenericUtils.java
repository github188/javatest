package com.test.collectionOperation;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Queue;
import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
* ������ø��ּ��϶���ĳ��÷����ķ��͹����ࡣ
* <p>
* ���Ҫ���һ�� {@code Map<String, String>} �Ķ��󣬿���ͨ������ķ�ʽʵ�֣�
* {@literal Map<String, String> map = GenericUtils.getMap();}�����ǲ���ֱ����Ϊ����ʹ�ã�����������һ��������
* {@literal setInfo(Map<String, String>)}������ֱ���������ã�<s>
* <code>setInfo(GenericUtils.getMap())</code></s>
* </p>
* 
* @author Fuchun
* @version $Id: GenericUtils.java 4754 2011-03-26 19:50 fuchun $
*/
public class GenericUtils {

    /**
     * �ø÷��������� {@code new HashMap<K, V>()} ��ʽ����µ� {@code java.util.Map} ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @return ���� {@code java.util.Map<K, V>} ���� {@code java.util.HashMap<K, V>} ʵ�ֵ���ʵ����
     */
    public static <K, V> Map<K, V> getMap() {
        return new HashMap<K, V>();
    }

    /**
     * �ø÷��������� {@code new HashMap<K, V>(int)} ��ʽ����µ� {@code java.util.Map} ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @param initialCapacity ��ʼ������
     * @return ���� {@code java.util.Map<K, V>} ���� {@code java.util.HashMap<K, V>} ʵ�ֵ���ʵ����
     */
    public static <K, V> Map<K, V> getMap(int initialCapacity) {
        return new HashMap<K, V>(initialCapacity);
    }

    /**
     * �ø÷��������� {@code new ConcurrentHashMap<K, V>()} ��ʽ����µ� {@code java.util.Map} ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @return ���� {@code java.util.Map<K, V>} ����
     *         {@code java.util.concurrent.ConcurrentHashMap<K, V>} ʵ�ֵ���ʵ����
     */
    public static <K, V> Map<K, V> getConcurrentMap() {
        return new ConcurrentHashMap<K, V>();
    }

    /**
     * �ø÷��������� {@code new ConcurrentHashMap<K, V>(int)} ��ʽ����µ� {@code java.util.Map}
     * ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @param initialCapacity ��ʼ������
     * @return ���� {@code java.util.Map<K, V>} ����
     *         {@code java.util.concurrent.ConcurrentHashMap<K, V>} ʵ�ֵ���ʵ����
     */
    public static <K, V> Map<K, V> getConcurrentMap(int initialCapacity) {
        return new ConcurrentHashMap<K, V>(initialCapacity);
    }

    /**
     * �ø÷��������� {@code new LinkedHashMap<K, V>()} ��ʽ����µ� {@code java.util.Map} ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @return ���� {@code java.util.Map<K, V>} ���� {@code java.util.LinkedHashMap<K, V>}
     *         ʵ�ֵ���ʵ����
     */
    public static <K, V> Map<K, V> getLinkedMap() {
        return new LinkedHashMap<K, V>();
    }

    /**
     * �ø÷��������� {@code new LinkedHashMap<K, V>(int)} ��ʽ����µ� {@code java.util.Map} ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @param initialCapacity ��ʼ������
     * @return ���� {@code java.util.Map<K, V>} ���� {@code java.util.LinkedHashMap<K, V>}
     *         ʵ�ֵ���ʵ����
     */
    public static <K, V> Map<K, V> getLinkedMap(int initialCapacity) {
        return new LinkedHashMap<K, V>(initialCapacity);
    }

    /**
     * �ø÷��������� {@code new TreeMap<K, V>()} ��ʽ����µ� {@code java.util.Map} ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @return ���� {@code java.util.Map<K, V>} ���� {@code java.util.TreeMap<K, V>} ʵ�ֵ���ʵ����
     */
    public static <K, V> Map<K, V> getTreeMap() {
        return new TreeMap<K, V>();
    }

    /**
     * �ø÷��������� {@code new ConcurrentHashMap<K, V>()} ��ʽ����µ�
     * {@code java.util.concurrent.ConcurrentHashMap} ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @return ���� {@code java.util.concurrent.ConcurrentMap<K, V>} ����
     *         {@code java.util.concurrent.ConcurrentHashMap<K, V>} ʵ�ֵ���ʵ����
     */
    public static <K, V> ConcurrentMap<K, V> getConcurrentHashMap() {
        return new ConcurrentHashMap<K, V>();
    }

    /**
     * �ø÷��������� {@code new ConcurrentHashMap<K, V>(int)} ��ʽ����µ�
     * {@code java.util.concurrent.ConcurrentHashMap} ��ʵ������
     * 
     * @param <K> {@code Map} �еļ�����
     * @param <V> {@code Map} �е�ֵ����
     * @param initialCapacity ��ʼ������
     * @return ���� {@code java.util.concurrent.ConcurrentMap<K, V>} ����
     *         {@code java.util.concurrent.ConcurrentHashMap<K, V>} ʵ�ֵ���ʵ����
     */
    public static <K, V> ConcurrentMap<K, V> getConcurrentHashMap(int initialCapacity) {
        return new ConcurrentHashMap<K, V>(initialCapacity);
    }

    /**
     * �ø÷��������� {@code new ArrayList<T>()} ��ʽ����µ� {@code java.util.List} ��ʵ������
     * 
     * @param <T> {@code List<T>} �б���Ķ���
     * @return ���� {@code java.util.List<T>} ���� {@code java.util.ArrayList<T>} ʵ�ֵ���ʵ����
     */
    public static <T> List<T> getList() {
        return new ArrayList<T>();
    }

    /**
     * �ø÷��������� {@code new ArrayList<T>(int)} ��ʽ����µ� {@code java.util.List} ��ʵ������
     * 
     * @param <T> {@code List<T>} �б���Ķ���
     * @param initialCapacity �б�ĳ�ʼ������
     * @return ���� {@code java.util.List<T>} ���� {@code java.util.ArrayList<T>} ʵ�ֵ���ʵ����
     */
    public static <T> List<T> getList(int initialCapacity) {
        return new ArrayList<T>(initialCapacity);
    }

    /**
     * �ø÷��������� {@code new ArrayList<T>()} ��ʽ����µ� {@code java.util.List} ��ʵ������
     * 
     * @param <T> {@code List<T>} �б���Ķ���
     * @param c ���е�Ԫ�ؽ�������µ� {@code list} �е� {@code collection}��
     * @return ���� {@code java.util.List<T>} ���� {@code java.util.ArrayList<T>} ʵ�ֵ���ʵ����
     */
    public static <T> List<T> getList(Collection<? extends T> c) {
        if (ObjectUtils.isNotEmpty(c))
            return new ArrayList<T>(c);
        return new ArrayList<T>();
    }

    /**
     * �ø÷��������� {@code new LinkedList<T>()} ��ʽ����µ� {@code java.util.List} ��ʵ������
     * 
     * @param <T> {@code List<T>} �б���Ķ���
     * @return ���� {@code java.util.List<T>} ���� {@code java.util.LinkedList<T>} ʵ�ֵ���ʵ����
     */
    public static <T> List<T> getLinkedList() {
        return new LinkedList<T>();
    }

    /**
     * �ø÷��������� {@code new HashSet<T>()} ��ʽ����µ� {@code java.util.Set} ��ʵ������
     * 
     * @param <T> {@code Set<T>} �б���Ķ���
     * @return ���� {@code java.util.Set<T>} ���� {@code java.util.HashSet<T>} ʵ�ֵ���ʵ����
     */
    public static <T> Set<T> getHashSet() {
        return new HashSet<T>();
    }

    /**
     * �ø÷��������� {@code new HashSet<T>(int)} ��ʽ����µ� {@code java.util.Set} ��ʵ������
     * 
     * @param <T> {@code Set<T>} �б���Ķ���
     * @param initialCapacity �б�ĳ�ʼ������
     * @return ���� {@code java.util.Set<T>} ���� {@code java.util.HashSet<T>} ʵ�ֵ���ʵ����
     */
    public static <T> Set<T> getHashSet(int initialCapacity) {
        return new HashSet<T>(initialCapacity);
    }

    /**
     * �ø÷��������� <code>new HashSet<T>(Collection<? extends T> c)</code> ��ʽ����µ�
     * {@code java.util.Set} ��ʵ������
     * 
     * @param <T> {@code Set} �б���Ķ���
     * @param c ���е�Ԫ�ؽ�������µ� {@code set} �е� {@code collection}��
     * @return ���� {@code java.util.Set<T>} ���� {@code java.util.HashSet<T>} ʵ�ֵ���ʵ����
     */
    public static <T> Set<T> getHashSet(Collection<? extends T> c) {
        if (ObjectUtils.isEmpty(c))
            return new HashSet<T>();
        return new HashSet<T>(c);
    }

    /**
     * �ø÷��������� {@code new TreeSet<T>()} ��ʽ����µ� {@code java.util.Set} ��ʵ������
     * 
     * @param <T> {@code Set<T>} �б���Ķ���
     * @return ���� {@code java.util.Set<T>} ���� {@code java.util.TreeSet<T>} ʵ�ֵ���ʵ����
     */
    public static <T> Set<T> getTreeSet() {
        return new TreeSet<T>();
    }

    /**
     * �ø÷��������� <code>new TreeSet<T>(Collection<? extends T> c)</code> ��ʽ����µ�
     * {@code java.util.Set} ��ʵ������
     * 
     * @param <T> {@code Set} �б���Ķ���
     * @param c ���е�Ԫ�ؽ�������µ� {@code set} �е� {@code collection}��
     * @return ���� {@code java.util.Set<T>} ���� {@code java.util.TreeSet<T>} ʵ�ֵ���ʵ����
     */
    public static <T> Set<T> getTreeSet(Collection<? extends T> c) {
        if (ObjectUtils.isEmpty(c))
            return new TreeSet<T>();
        return new TreeSet<T>(c);
    }

    /**
     * �ø÷��������� {@code new LinkedList<E>()} ��ʽ����µ� {@code java.util.Queue} ��ʵ������
     * 
     * @param <E> {@code Queue<E>} �б���Ķ���
     * @return ���� {@code java.util.Queue<E>} ���� {@code java.util.LinkedList<E>} ʵ�ֵ���ʵ����
     */
    public static <E> Queue<E> getQueue() {
        return new LinkedList<E>();
    }

    /**
     * �ϲ���������ͬԪ�����͵� {@code java.util.Set}��
     * <ul>
     * <li>{@code setA == null && setB == null} --> ���� {@link #getHashSet()}��</li>
     * <li>{@code setA != null && setB == null} --> ���� {@code setA}��</li>
     * <li>{@code setA == null && setB != null} --> ���� {@code setB}��</li>
     * <li>{@code setA != null && setB != null} --> ���� {@code setA} �� {@code setB} �Ĳ�����
     * </li>
     * </ul>
     * 
     * @param <T> {@code Set} �б���Ķ���
     * @param setA ��һ�� {@code Set}��
     * @param setB �ڶ��� {@code Set}��
     * @return ���� {@code setA} �� {@code setB} �Ĳ�����
     */
    public static <T> Set<T> unionHashSet(Set<T> setA, Set<T> setB) {
        boolean isEmptySetA = ObjectUtils.isEmpty(setA);
        boolean isEmptySetB = ObjectUtils.isEmpty(setB);
        if (isEmptySetA && isEmptySetB)
            return getHashSet();
        if (isEmptySetA && !isEmptySetB)
            return setB;
        if (!isEmptySetA && isEmptySetB)
            return setA;
        Set<T> result = getHashSet(setA);
        result.addAll(setB);
        return result;
    }

    /**
     * ȡ��������ͬԪ�����͵� {@code java.util.Set} �Ľ��������������ݵ��µ� {@code java.util.Set}��
     * <ul>
     * <li>{@code setA == null && setB == null} --> ���� {@code null}��</li>
     * <li>{@code setA != null && setB == null} --> ���� {@code null}��</li>
     * <li>{@code setA == null && setB != null} --> ���� {@code null}��</li>
     * <li>{@code setA != null && setB != null} --> ���� {@code setA} �� {@code setB} �Ľ�����
     * </li>
     * </ul>
     * 
     * @param <T> {@code Set} �б���Ķ���
     * @param setA ��һ�� {@code Set}��
     * @param setB �ڶ��� {@code Set}��
     * @return ���� {@code setA} �� {@code setB} �Ľ�����
     */
    public static <T> Set<T> intersectHashSet(Set<T> setA, Set<T> setB) {
        if (ObjectUtils.isEmpty(setA) || ObjectUtils.isEmpty(setB))
            return null;
        Set<T> result = getHashSet(setA);
        result.retainAll(setB);
        return result;
    }

    /**
     * �Ƴ� {@code setA} ����Щ������ {@code setB} �е�Ԫ�ء�<br />
     * �˷��������޸� {@code setA}��ֻ�Ǹ���һ������Ӧ���������ص���ȫ�µ� {@code Set} ����
     * <ul>
     * <li>{@code setA == null} --> ���� {@code null}��</li>
     * <li>{@code setB == null} --> ���� {@code setA}��</li>
     * <li>{@code setA != null && setB != null} --> ���� {@code setA} �� {@code setB}
     * �Ĳ��ԳƲ��</li>
     * </ul>
     * 
     * @param <T> {@code Set} �б���Ķ���
     * @param setA ��һ�� {@code Set}��
     * @param setB �ڶ��� {@code Set}��
     * @return ���� {@code setA} �� {@code setB} �Ĳ��ԳƲ��
     */
    public static <T> Set<T> differenceHashSet(Set<T> setA, Set<T> setB) {
        if (ObjectUtils.isEmpty(setA))
            return null;
        if (ObjectUtils.isEmpty(setB))
            return setA;
        Set<T> result = getHashSet(setA);
        result.removeAll(setB);
        return result;
    }

    /**
     * ȡ��������ͬԪ�����͵� {@code java.util.Set} �Ĳ�����
     * 
     * @param <T> {@code Set} �б���Ķ���
     * @param setA ��һ�� {@code Set}��
     * @param setB �ڶ��� {@code Set}��
     * @return ���� {@code setA} �� {@code setB} �Ĳ�����
     */
    public static <T> Set<T> complementHashSet(Set<T> setA, Set<T> setB) {
        return differenceHashSet(unionHashSet(setA, setB), intersectHashSet(setA, setB));
    }
}
