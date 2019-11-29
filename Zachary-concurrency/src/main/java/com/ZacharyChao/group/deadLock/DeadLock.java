package com.ZacharyChao.group.deadLock;

public class DeadLock {
	public static String file1 = "文件A";
	public static String file2 = "文件2";
	public static void main(String[] args) {
		while(true) {
			new Thread() {
				public void run() {
					synchronized(file1) {
						System.out.println(this.getName() + "读取文件fileA");
						synchronized(file2) {
							System.out.println(this.getName() + "读取文件fileB");
						}
					}
				};
			}.start();
			new Thread() {
				public void run() {
					synchronized(file2) {
						System.out.println(this.getName() + "读取文件fileB");
						synchronized(file1) {
							System.out.println(this.getName() + "读取文件fileA");
						}
					}
				};
			}.start();
		}
	}
}
