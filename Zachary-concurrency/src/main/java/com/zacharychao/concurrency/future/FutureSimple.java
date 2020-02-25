package com.zacharychao.concurrency.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSimple {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int i = 2 ; i <= 10 ; i ++) {
			Computer c = new Computer();
			c.setNum(i);
			Future<Boolean> future = threadPool.submit(c);
			try {
				Boolean b = future.get();
				if(b) {
					System.out.println(i + "ÊÇÖÊÊý" );
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		threadPool.shutdown();
		
	}
}
class Computer implements Callable<Boolean>{
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public Boolean call() throws Exception{
		for(int i = 2 ; i < num ; i ++) {
			if(num % i == 0 ) {
				return false;
			}
		}
		return true;
	}
}
