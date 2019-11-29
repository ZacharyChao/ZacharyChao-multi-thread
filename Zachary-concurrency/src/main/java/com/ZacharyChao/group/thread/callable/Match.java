package com.ZacharyChao.group.thread.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Match {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Runner liuxiang = new Runner();
		liuxiang.setName("¡ıœË");
		ExecutorService service = Executors.newFixedThreadPool(3);
		Runner run1 = new Runner();
		run1.setName("liufei");
		
		Future<Integer> result1 = service.submit(liuxiang);
		Future<Integer> result2 = service.submit(run1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(liuxiang.getName() + " has run " + result1.get());
		System.out.println(run1.getName() + " has run " + result2.get());
		service.shutdown();
	}
	
}
class Runner implements Callable<Integer>{
	private String name ;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public Integer call() {
		Integer distince = 0;
		Integer speed = new Random().nextInt(100);
		for(int i = 0 ; i < 100 ; i ++) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			distince = i * speed;
			System.out.println(this.name + " has run about " + distince + " km with " + speed + "km/h");
		}
		
		return distince;
	}
}