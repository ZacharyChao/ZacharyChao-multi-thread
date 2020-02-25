package com.zacharychao.concurrency.deadLock;

public class DeadLock {
	public static String fileA = "fileA";
	public static String fileB = "fileB";
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				while(true) {
					synchronized(fileA) {
						System.out.println(this.getName() + ": д���ļ�A");
						synchronized(fileB) {
							System.out.println(this.getName() + ": д���ļ�B");
						}
					}
					System.out.println(this.getName() + "�����ļ�д�����");
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					synchronized(fileB) {
						System.out.println(this.getName() + ": д���ļ�B");
						synchronized(fileA) {
							System.out.println(this.getName() + ": д���ļ�A");
						}
					}
					System.out.println(this.getName() + "�����ļ�д�����");
				}
			}
		}.start();
	}
}
