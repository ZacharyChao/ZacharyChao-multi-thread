package com.zacharychao.concurrency.cyclicBarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierSimple {
	public static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int i = 0 ; i < 20 ; i ++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadPool.execute(new Runnable() {
				public void run() {
					go();
					
				}
			});
		}
		threadPool.shutdown();
	}
	private static void go() {
		System.out.println(Thread.currentThread().getName() + "**" + new Date() + " 准备就绪");
		try {
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName() + "**" + new Date() + " 开始运行");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
