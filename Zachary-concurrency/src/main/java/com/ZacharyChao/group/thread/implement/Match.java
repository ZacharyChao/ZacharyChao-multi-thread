package com.ZacharyChao.group.thread.implement;

import java.util.Random;

public class Match {
	public static void main(String[] args) {
		Runner liuxiang = new Runner();
		Thread thread1 = new Thread(liuxiang);
		thread1.setName("ÁõÏè");
		Thread thread2 = new Thread(new Runner());
		thread2.setName("Â··É");
		thread2.start();
		thread1.start();
		
	}
}
class Runner implements Runnable{

	public void run() {
		int speed = new Random().nextInt(100);
		for(int i = 0 ; i < 100 ; i ++) {
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" run about " + speed * i + "km ("+speed +"km/h)");
		}
	}
	
}