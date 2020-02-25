package com.zacharychao.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolSimple {
	public static void main(String[] args) {
		/*
		 * ExecutorService��������̳߳�
		 * newCachedThreadPool�ɻ����̳߳ص��ص��ǣ����޴�����̳߳���û�п��õ��߳��򴴽����п���������
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
			 * ���߳��㹻������ʱ��
			 */
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * ʹ����Ϻ�ر��̳߳�
		 * shutdown����ر��̳߳أ��ȴ������߳�ִ���꣩
		 * shutdownNow���������رգ������Ƿ����߳�û��ִ���꣬���Ƽ�ʹ��
		 */
		threadPool.shutdown();
	}
}
