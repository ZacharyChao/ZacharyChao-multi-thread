package com.zacharychao.concurrency.semaphore;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreSimple {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(5);//����5���ź�������������ֻ����5������������
		for(int i = 1 ; i <= 20 ; i ++) {
			threadPool.execute(new Runnable() {
				public void run() {
					try {
						semaphore.acquire();//��ȡһ���ź�������ռ��һ���ܵ�
						play();
						semaphore.release();//ִ������ͷ��ź�������������ܵ���ȥ
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
		System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "���������");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " ***** " + new Date() + "�˳�������");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
