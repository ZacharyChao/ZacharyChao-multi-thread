package com.zacharychao.concurrency.semaphore;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreSimple2 {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(5);
		for(int i = 1 ; i <= 20 ; i ++) {
			threadPool.execute(new Runnable() {
				public void run() {
					try {
						if(semaphore.tryAcquire(4, TimeUnit.SECONDS)) {//尝试获取信号量，获取成功返回true，否则返回false
							play();
							semaphore.release();
						}else {
							System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "禁止服务器");
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		threadPool.shutdown();
	}
	public static void play() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "进入服务器");
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "退出服务器");
		Thread.sleep(500);
	}
}
