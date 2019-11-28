package com.ZacharyChao.group.thread.extend;

import java.util.Random;

public class Match {
	public static void main(String[] args) {
		Runner run1 = new Runner();
		run1.setName("ÁõÏè");
		Runner run2 = new Runner();
		run2.setName("Â··É");
		run2.start();
		run1.start();
	}
}
class Runner extends Thread{
	@Override
	public void run() {
		int speed = new Random().nextInt(100);
		for(int i = 0 ; i < 100 ; i ++) {
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName()+" run about " + speed * i + "km ("+speed +"km/h)");
		}
	}
}