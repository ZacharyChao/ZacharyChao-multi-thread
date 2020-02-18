package com.zacharychao.concurrency.runnable;

import java.util.Random;

public class Match {
	public static void main(String[] args) {
		Thread runner = new Thread(new Runner());
		runner.setName("Runner2");
		runner.start();
	}
}
class Runner implements Runnable{

	@Override
	public void run() {
		Integer speed = new Random().nextInt(100);
		for(int i = 0 ; i < 100 ; i ++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "********" + i * speed + "km");
		}
	}
	
}
