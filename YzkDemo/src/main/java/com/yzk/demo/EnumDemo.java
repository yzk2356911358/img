package com.yzk.demo;

public class EnumDemo {
	enum Car {
		RED(12), BULE(12);

		private int price;

		Car(int p) {
			price = p;
		}

		int getPrice() {
			return price;
		}
	}

	public static void main(String args[]) {
		System.out.println("所有汽车的价格：");
		for (Car car : Car.values()) {
			System.out.println("汽车名称：" + car + "价格：" + car.price);
		}
	}
}
