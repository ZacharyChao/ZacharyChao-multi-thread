package com.zacharychao.concurrency.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Match {
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.setName("runner");
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		Future<Integer> submit = newFixedThreadPool.submit(runner);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("ภÛผฦลÜมห " + submit.get() + "รื");
		} catch (Exception e) {
			e.printStackTrace();
		}
		newFixedThreadPool.shutdown();
	}
}

class Runner implements Callable<Integer>{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer call() throws Exception {
		Integer distince = 0;
		Integer speed = new Random().nextInt(100);
		for(int i = 0 ; i <= 100 ; i ++) {
			distince = i * speed;
			System.out.println(this.getName() + "*********" + distince + " km , " + speed + "km/h");
		}
		return distince;
	}
}
