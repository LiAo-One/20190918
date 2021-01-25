package com.liao.test;

public class Test01 {
	public static void main(String[] args) {
		String num = "";
		for (int i = 0; i < 8; i++) {
			num += (int)(Math.random()*10);
		}
		System.out.println(num);
	}
}
