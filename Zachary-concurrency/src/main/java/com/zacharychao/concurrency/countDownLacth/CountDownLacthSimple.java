package com.zacharychao.concurrency.countDownLacth;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLacthSimple {
	public static int count = 0;
	public static void main(String[] args) {
		countDownLacth();
	}
	public static void countDownLacth() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		CountDownLatch cdl = new CountDownLatch(1000);
		for(int i = 1 ; i <= 1000 ; i ++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					synchronized(CountDownLacthSimple.class) {
						try {
							count = count + index;
						}catch(Exception e) {
							e.printStackTrace();
						}finally {
							cdl.countDown();
							System.out.println(cdl.getCount());
						}
					}
				}
			});
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);
		fixedThreadPool.shutdown();
	}
	public static void unCountDownLatch() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for(int i = 1 ; i <= 100000 ; i ++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					synchronized(CountDownLacthSimple.class) {
						count = count + index;
					}
				}
			});
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);
		fixedThreadPool.shutdown();
	}
}
