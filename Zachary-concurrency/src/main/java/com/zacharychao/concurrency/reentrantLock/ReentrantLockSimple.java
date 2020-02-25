package com.zacharychao.concurrency.reentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSimple {
//	public static int users = 4;
	public static int totalDownload = 10000;
	public static int count = 0;
	public static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
//		Semaphore semaphore = new Semaphore(users);
		for(int i = 0 ; i < totalDownload ; i ++) {
			threadPool.execute(new Runnable() {
				public void run() {
//					try {
////						semaphore.acquire();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					add();
//					semaphore.release();
				}
			});
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
		threadPool.shutdown();
	}
	public static void add() {
		lock.lock();
		try {
			count ++; 
		}finally {
			lock.unlock();
		}
	}
}
