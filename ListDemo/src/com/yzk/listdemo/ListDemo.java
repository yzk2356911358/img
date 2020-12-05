package com.yzk.listdemo;

import java.util.ArrayList;

public class ListDemo {
	public static void test0() throws InterruptedException {
		long start = System.currentTimeMillis();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i <= 10000000;) {
			arrayList.add(i);
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList集合添加10000000条数据耗时:" + (end - start));
	}
	public static void main(String[] args) {
		try {
			ListDemo.test0();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}