package com.zacharychao.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DownLoadSample {
	public static int users = 4;
	public static int downTotal = 50000;
	public static int count = 0;
	
	public static void main(String[] args) {
		//��������jdk1.5���ڲ�����֧��
		ExecutorService service = Executors.newCachedThreadPool();
		//�ź���������ģ�Ⲣ��������
		final Semaphore semaphore = new Semaphore(users);
		for(int i = 0 ; i < downTotal ; i ++) {
			service.execute(() -> {
				//��ȡ�ź���
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
