package com.zacharychao.concurrency.threadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolSimple {
	public static void main(String[] args) {
		scheduleAtFixedRate();
	}
	//�ӳ�ִ������
	public static void schedule() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println(new Date() + "�ӳ�3��ִ��");
			}
		}, 3, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scheduledThreadPool.shutdown();
	}
	//�ӳ�1�����У�ÿ��3������һ��
	public static void scheduleAtFixedRate() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
		//ʵ�ʿ����У�scheduleThreadPool��Timer�������õ�����Ϊ�г���ĵ��ȿ��Quartz������spring�Դ��ĵ��ȣ�
		//����ĵ��ȿ��֧��һ�ֱ��ʽ����CRON���ʽ
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "*****" + new Date() );
			}
		}, 1, 3, TimeUnit.SECONDS);
	}
}
