package com.zacharychao.concurrency.sync;

import java.util.Random;

public class SyncSample {
	public static void main(String[] args) {
		Couplet c = new Couplet();
		for(int i = 0 ; i < 10000 ; i ++) {
			new Thread() {
				public void run() {
					int i = new Random().nextInt(2);
					if(i % 2 == 0) {
						c.first();
					}else if(i % 2 == 1) {
						c.second();
					}
				}
			}.start();
		}
	}
}

class Couplet{
	Object lock = new Object();
	public void first() {
		synchronized(lock) {
			System.out.printf("��");
			System.out.printf("ɪ");
			System.out.printf("��");
			System.out.printf("��");
			System.out.println();
		}
	}
	
	public void second() {
		synchronized(lock) {
			System.out.printf("��");
			System.out.printf("��");
			System.out.printf("��");
			System.out.printf("��");
			System.out.println();
		}
	}
}
