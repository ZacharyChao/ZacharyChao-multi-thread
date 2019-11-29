package com.ZacharyChao.group.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		/*
		 * scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
		 * 
		 * @Override public void run() { System.out.println(new Date() + " ---- " +
		 * Thread.currentThread().getName()); } }, 2, 2, TimeUnit.SECONDS);
		 */
		scheduledThreadPool.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("—” ±");
			}
		}, 3, TimeUnit.SECONDS);
		
		
	}
}
