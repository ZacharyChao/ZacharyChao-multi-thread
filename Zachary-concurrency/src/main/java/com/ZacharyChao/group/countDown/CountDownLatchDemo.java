package com.ZacharyChao.group.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
	public static int count = 0;
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(10000);
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
		for(int i = 0 ; i <= 10000 ; i ++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					synchronized(CountDownLatchDemo.class) {
						try {
							count = count + index;
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							cdl.countDown();
						}
					}
					
				}
			});
		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
		fixedThreadPool.shutdown();
	}
}
