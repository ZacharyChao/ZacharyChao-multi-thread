package com.zacharychao.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorSimple {
	public static void main(String[] args) {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		singleThreadExecutor.execute(new Runnable() {
			public void run() {
				for(int i = 0 ; i < 1000 ; i ++) {
					final int index = i ;
					System.out.println(Thread.currentThread().getName() + "******" + index);
				}
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		singleThreadExecutor.shutdown();
	}
}
