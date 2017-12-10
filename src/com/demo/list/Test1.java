package com.demo.list;

import java.sql.Timestamp;

public class Test1 {
	public static void main(String[] args) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		Timestamp tsd=null;
		System.out.println(ts);
        //String tsStr = "2011-05-09 11:49:45";   
		String tsStr = "2011-05-09";  
		tsStr=tsStr+" "+"55:55:55";
        try {   
            tsd = Timestamp.valueOf(tsStr);   
            System.out.println(tsd);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  

	}

//	// method1
//	public static void addNum(int a, int b) {
//
//		System.out.println(a + b);
//	}
//
//	// method2
//	public static void method2() {
//
//		System.out.println("这是method2");
//	}
//
//	// method3
//	public static void method3() {
//
//		System.out.println("这是method3");
//	}
//
//	// method4
//	public static void method4() {
//
//		System.out.println("这是method4");
//	}

}
