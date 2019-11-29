package com.ZacharyChao.group.unsaft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Downloads {
	private static int count = 0;
	private static int downTotal = 50000;
	public static int users = 500;
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(users);
		for(int i = 0 ; i < downTotal ; i ++ ) {
			service.execute(()->{
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
		System.out.println(count);
	}
	
	public static void add() {
		count ++;
	}
}
