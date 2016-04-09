package com.handsomezhou.Calculate;

public class Calculate{
public native static int plus(int x,int y); 
public native static int minus(int x,int y);

static {
    System.loadLibrary("Calculate");   
}

public static void main(String[] args){  
	
    System.out.println("1+1="+plus(1,1));    
	System.out.println("2-1="+minus(2,1));   
}

}