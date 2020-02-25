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
						if(semaphore.tryAcquire(4, TimeUnit.SECONDS)) {//���Ի�ȡ�ź�������ȡ�ɹ�����true�����򷵻�false
							play();
							semaphore.release();
						}else {
							System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "��ֹ������");
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
		System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "���������");
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "�˳�������");
		Thread.sleep(500);
	}
}
