package com.test.pattern.command;
/**
 * ���������
 * @author �ų�
 *
 * Dec 17, 2012
 */
public class Invoker {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void execute() {
		this.command.execute();
	}
}
