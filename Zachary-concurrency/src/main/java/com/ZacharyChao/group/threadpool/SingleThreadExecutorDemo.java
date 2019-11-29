package com.ZacharyChao.group.threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
	public static void main(String[] args) {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for(int i = 0 ; i < 100 ; i ++)
		{
			int index = i;
			singleThreadExecutor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + " ---- " + index);
				}
			});
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		singleThreadExecutor.shutdown();
	}
}
