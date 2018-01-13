package com.lee.demo.thread;

class Toast {

	public enum Status {
		DRY, BUTTERD, JAMMED
	}
	
	private Status status = Status.DRY;
	private final int id;
	public Toast(int idn) {
		id = idn;
	}
	public void butter() {
		status = Status.BUTTERD;
	}
	public void jam() {
		status = Status.JAMMED;
	}
	public Status getStatus() {
		return status;
	}
	public int getId() {
		return id;
	}
	public String toString(){
		return "Toast " + id + ": " + status;
	}
}
