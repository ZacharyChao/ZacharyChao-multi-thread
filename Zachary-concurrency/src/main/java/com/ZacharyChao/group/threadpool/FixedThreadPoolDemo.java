package com.ZacharyChao.group.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for(int i = 0 ; i < 100 ; i ++)
		{
			int index = i;
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + " ---- " + index);
				}
			});
		}
		fixedThreadPool.shutdown();
	}
}
