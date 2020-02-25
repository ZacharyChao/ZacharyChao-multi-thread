package com.zacharychao.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolSimple {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(int i = 0 ; i < 1000 ; i ++) {
			final int index = i;
			service.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "****" + index);
				}
			});
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.shutdown();
	}
}
