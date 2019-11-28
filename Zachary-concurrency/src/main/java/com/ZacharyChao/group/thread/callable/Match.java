package com.ZacharyChao.group.thread.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Match {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Runner liuxiang = new Runner();
		liuxiang.setName("¡ıœË");
		Future<Integer> result = service.submit(liuxiang);
		service.shutdown();
		System.out.println("liuxiang has run " + result.get() + "km");
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
	public Integer call() throws Exception {
		Integer speed = new Random().nextInt(100);
		int distince = 0;
		for(int i = 0 ; i < 100 ; i ++) {
			Thread.sleep(100);
			distince = i * speed;
			System.out.println(this.name + " has run about " + distince + " km with " + speed + "km/h");
		}
		
		return distince;
	}}