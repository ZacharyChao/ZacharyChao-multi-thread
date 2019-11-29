package com.ZacharyChao.group.deadLock;

public class DeadLock {
	public static String file1 = "�ļ�A";
	public static String file2 = "�ļ�2";
	public static void main(String[] args) {
		while(true) {
			new Thread() {
				public void run() {
					synchronized(file1) {
						System.out.println(this.getName() + "��ȡ�ļ�fileA");
						synchronized(file2) {
							System.out.println(this.getName() + "��ȡ�ļ�fileB");
						}
					}
				};
			}.start();
			new Thread() {
				public void run() {
					synchronized(file2) {
						System.out.println(this.getName() + "��ȡ�ļ�fileB");
						synchronized(file1) {
							System.out.println(this.getName() + "��ȡ�ļ�fileA");
						}
					}
				};
			}.start();
		}
	}
}
