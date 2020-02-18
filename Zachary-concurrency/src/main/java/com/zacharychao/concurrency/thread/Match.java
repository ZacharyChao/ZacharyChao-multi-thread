package com.zacharychao.concurrency.thread;

import java.util.Random;

/**
 * ºÃ≥–Thread
 * @author Administrator
 *
 */
public class Match {
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.setName("‘À∂Ø‘±1");
		runner.start();
	}

}
class Runner extends Thread{
	@Override
	public void run() {
		Integer speed = new Random().nextInt(100);
		for(int i = 0 ; i < 100 ; i ++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName() + " ******* " + i * speed + "km");
		}
	}
}
