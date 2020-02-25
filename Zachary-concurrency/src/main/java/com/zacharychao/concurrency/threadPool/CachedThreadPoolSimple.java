package com.zacharychao.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolSimple {
	public static void main(String[] args) {
		/*
		 * ExecutorService负责管理线程池
		 * newCachedThreadPool可缓存线程池的特点是：无限大，如果线程池中没有可用的线程则创建，有空闲则利用
		 */
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		for(int i = 0 ; i < 1000 ; i ++) {
			final int index = i;
			threadPool.execute(new Runnable() {
				public void run () {
					System.out.println(Thread.currentThread().getName() + "*****" + index);
				}
			});
		}
		try {
			/*
			 * 给线程足够的运行时间
			 */
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * 使用完毕后关闭线程池
		 * shutdown代表关闭线程池（等待所有线程执行完）
		 * shutdownNow代表立即关闭，无论是否有线程没有执行完，不推荐使用
		 */
		threadPool.shutdown();
	}
}
