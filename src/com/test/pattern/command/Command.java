package com.test.pattern.command;
/**
 * ���������
 * @author �ų�
 * 2012-8-23����03:57:25
 *
 */
public abstract class Command {
	protected Reviever reciever;
	
	public Command(Reviever reciever) {
		this.reciever = reciever;
	}

	public abstract void execute();
}
