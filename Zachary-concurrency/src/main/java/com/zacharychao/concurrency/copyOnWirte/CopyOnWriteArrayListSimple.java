package com.zacharychao.concurrency.copyOnWirte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListSimple {
	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<Integer>();
//		for(int i = 0 ; i < 10000 ; i ++) {
//			list.add(i);
//		}
//		Iterator<Integer> iter = list.iterator();
//		while(iter.hasNext()) {
//			Integer v = iter.next();
//			iter.remove();
//		}
//		System.out.println(list);
		
		List<Integer> list = new CopyOnWriteArrayList<Integer>();
		for(int i = 0 ; i < 10000 ; i ++) {
			list.add(i);
		}
		
		Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext()) {
			Integer i = iter.next();
			list.remove(i);
		}
		
		System.out.println(list);
	}
}
