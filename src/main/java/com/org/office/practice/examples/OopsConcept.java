package com.org.office.practice.examples;

public class OopsConcept {
	
	 int a;
	 int b;

	   
	    public void setA(int a) {
	    	this.a = a;
	    	}
	    public void setB(int b) {
	    	this.b = b; 
	    	}

	   
	    public void sum() {
	    	System.out.println(a + b); 
	    	}
	    public void sub() {
	    	System.out.println(a - b); 
	    	}

	    public static void main(String[] args)
	    {
	    	 OopsConcept obj = new  OopsConcept();

	        
	        obj.setA(1);
	        obj.setB(2);

	        obj.sum();
	        obj.sub();
	    }
	    
	    
	    
	    
}


