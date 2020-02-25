package com.zacharychao.concurrency.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Future<Integer> future = threadPool.submit(new RunnerDemo());
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.shutdown();
	}
}
class RunnerDemo implements Callable<Integer>{
	public Integer call() {
		Integer distince = 0;
		Integer speed = new Random().nextInt(100);
		for(int i = 1 ; i < 1000 ; i ++) {
			distince = speed * i;
			System.out.println("ลÜมห" + distince + "km");
		}
		return distince;
	}
}
