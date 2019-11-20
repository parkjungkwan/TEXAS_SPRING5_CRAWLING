package com.wego.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
	 @Autowired Box<Integer> box;
	 
     public int sum(int a, int b) {
    	 
    	   box.put("a", a + b);
           return box.get("a");
     }
     public int subtract(int a, int b) {
           return a - b;
     }
     public int absoluteVal(int a) {
        return Math.abs(a);
    }
}