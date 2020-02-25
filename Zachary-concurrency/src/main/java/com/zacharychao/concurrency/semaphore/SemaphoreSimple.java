package com.zacharychao.concurrency.semaphore;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreSimple {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(5);//定义5个信号量，即服务器只允许5个人在里面玩
		for(int i = 1 ; i <= 20 ; i ++) {
			threadPool.execute(new Runnable() {
				public void run() {
					try {
						semaphore.acquire();//获取一个信号量，即占用一条跑道
						play();
						semaphore.release();//执行完毕释放信号量，即从这个跑到出去
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		threadPool.shutdown();
	}

	public static void play() {
		System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "进入服务器");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "退出服务器");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
