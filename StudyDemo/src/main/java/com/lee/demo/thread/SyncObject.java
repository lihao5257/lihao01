package com.lee.demo.thread;

public class SyncObject {

	public static void main(String[] args) {

		final DualSynch dualSynch = new DualSynch();

		new Thread(()-> dualSynch.f()).start();
/*		new Thread() {
			public void run() {
				dualSynch.f();
			}
		}.start();*/
		dualSynch.g();
	}
}
