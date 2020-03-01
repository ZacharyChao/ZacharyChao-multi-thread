package com.zacharychao.concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadSimple {
	public static int users = 5;
	public static int downTatol = 100000;
	public static AtomicInteger count = new AtomicInteger();
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(5);
		for(int i = 0 ; i < downTatol ; i ++) {
			threadPool.execute(new Runnable() {
				public void run() {
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					add();
					semaphore.release();
				}
			});
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.shutdown();
		System.out.println(count.get());
	}
	
	public static void add() {
//		synchronized(DownloadSimple.class){
			count.getAndIncrement();
//		}
	}
}
