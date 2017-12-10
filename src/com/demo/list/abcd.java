package com.demo.list;

public class abcd {
	public static void main(String[] args) {
		//System.out.println("123465");
		
		String s = "jfdsjfas%fdjljgj,fjdhfkljs%flkgl,lfojjh%fdgdtgr";
		System.out.println(s);
		String[] productIdsArray = s.split(",");
		//System.out.println(productIdsArray);
		System.out.println("----------------------");
		for(int i=0;i<productIdsArray.length;i++){
			String before = productIdsArray[i];
			System.out.println(before);
			String last = before.replaceAll("%", ",");
			System.out.println(last);
			System.out.println("----------------------");
		}
		
	}
}
