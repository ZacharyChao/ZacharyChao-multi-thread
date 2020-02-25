package com.zacharychao.concurrency.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSimple {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition c1 = lock.newCondition();
		Condition c2 = lock.newCondition();
		Condition c3 = lock.newCondition();
		
		new Thread(new Runnable() {
			public void run() {
				lock.lock();
				try {
					c1.await();
					Thread.sleep(1000);
					System.out.println("4");
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				lock.lock();
				try {
					c2.await();
					Thread.sleep(1000);
					System.out.println("3");
					c1.signal();
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				lock.lock();
				try {
					c3.await();
					Thread.sleep(1000);
					System.out.println(2);
					c2.signal();
				}catch(Exception e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				lock.lock();
				try {
					System.out.println(1);
					c3.signal();
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}).start();
	}
}
