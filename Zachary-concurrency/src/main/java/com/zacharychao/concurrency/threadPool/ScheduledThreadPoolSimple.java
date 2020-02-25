package com.zacharychao.concurrency.threadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolSimple {
	public static void main(String[] args) {
		scheduleAtFixedRate();
	}
	//延迟执行任务
	public static void schedule() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println(new Date() + "延迟3秒执行");
			}
		}, 3, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scheduledThreadPool.shutdown();
	}
	//延迟1秒运行，每隔3秒运行一次
	public static void scheduleAtFixedRate() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
		//实际开发中，scheduleThreadPool和Timer都不会用到，因为有成熟的调度框架Quartz，或者spring自带的调度，
		//程序的调度框架支持一种表达式叫做CRON表达式
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "*****" + new Date() );
			}
		}, 1, 3, TimeUnit.SECONDS);
	}
}
