package com.lee.demo.lambda;

public class LiftOff implements Runnable{

	protected int countDown = 10;
	private static int taskCount = 0;
	// �?�?符id可以用来区�?任务�?多个实例，�?是final�?�?
	// �?为�?�?旦被初始化之后就不希望被修改
    private final int id = taskCount++;
	public LiftOff() {}
	public LiftOff(int countDown) {
		
	}
	public String status() {
		return "#" + id + "(" + 
	(countDown > 0 ? countDown : "LiftOff") + ").";
	}
	public void run() {
		
		while(countDown-- > 0){
			System.out.println(status());
			Thread.yield();
		}
	}
}
