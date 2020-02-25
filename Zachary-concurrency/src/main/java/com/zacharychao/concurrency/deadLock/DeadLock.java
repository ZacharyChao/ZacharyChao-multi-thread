package com.zacharychao.concurrency.deadLock;

public class DeadLock {
	public static String fileA = "fileA";
	public static String fileB = "fileB";
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				while(true) {
					synchronized(fileA) {
						System.out.println(this.getName() + ": 写入文件A");
						synchronized(fileB) {
							System.out.println(this.getName() + ": 写入文件B");
						}
					}
					System.out.println(this.getName() + "所有文件写入完毕");
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					synchronized(fileB) {
						System.out.println(this.getName() + ": 写入文件B");
						synchronized(fileA) {
							System.out.println(this.getName() + ": 写入文件A");
						}
					}
					System.out.println(this.getName() + "所有文件写入完毕");
				}
			}
		}.start();
	}
}
