package com.demo.list;

import org.junit.Test;

public class Test1_juint {
	@Test
	public void testAddNum(){  
        
        Test1 ts=new Test1();  
        ts.addNum(3, 6);  
    }  
         
	@Test  
    public void testm2(){  
        Test1 ts=new Test1();  
        ts.method2();  
    }  
      
	@Test  
    public void testm3(){  
        Test1 ts=new Test1();  
        ts.method3();  
    }  
      
	@Test  
    public void testm4(){  
        Test1 ts=new Test1();  
        ts.method4();  
    }  

}
