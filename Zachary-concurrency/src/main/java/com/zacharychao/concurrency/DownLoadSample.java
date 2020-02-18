package com.zacharychao.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DownLoadSample {
	public static int users = 4;
	public static int downTotal = 50000;
	public static int count = 0;
	
	public static void main(String[] args) {
		//调度器，jdk1.5对于并发的支持
		ExecutorService service = Executors.newCachedThreadPool();
		//信号量，用于模拟并发的人数
		final Semaphore semaphore = new Semaphore(users);
		for(int i = 0 ; i < downTotal ; i ++) {
			service.execute(() -> {
				//获取信号量
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		service.shutdown();
		System.out.println(count);
	}
	
	public static void add() {
		count ++;
	}
}
