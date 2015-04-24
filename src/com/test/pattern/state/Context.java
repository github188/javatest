package com.test.pattern.state;
/**
 * ��װ״̬�ı������Ĺ��ܱ仯
 * @author �ų�
 * 2012-8-2����02:02:37
 *
 */
public class Context {

	public final static OpeningState openningState = new OpeningState();
	public final static CloseingState closeingState = new CloseingState();
	public final static RunningState runningState = new RunningState();
	public final static StoppingState stoppingState = new StoppingState();

	private LiftState liftState;

	public LiftState getLiftState() {
		return liftState;
	}

	public void setLiftState(LiftState liftState) {
		this.liftState = liftState;
		this.liftState.setContext(this);
	}

	public void open() {
		this.liftState.open();
	}

	public void close() {
		this.liftState.close();
	}

	public void run() {
		this.liftState.run();
	}

	public void stop() {
		this.liftState.stop();
	}

}
