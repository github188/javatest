package com.test.pattern.observer;

/**
 * ���۲���
 * @author �ų�
 * 2012-7-31����10:33:42
 *
 */
public interface Observable {

	public void addObserver(Observer o);
	
	public void deleteObserver(Observer o);
	
	public void notifyAllObservers(String context);
}
