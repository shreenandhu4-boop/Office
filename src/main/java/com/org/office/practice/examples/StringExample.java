package com.org.office.practice.examples;

import java.util.StringTokenizer;

public class StringExample {
	public static void main(String[] args) {
		
//		String name = "Bharathan";
//		String name2= name.replaceAll("a", "a-");//Bha-ra-tha-n
//		String[] st = name2.split("-");
//		for(String s1 : st) {
//			System.out.println(s1);
//		}
//		
//		
		String s = "I want to walk my dog";
//		String[] arr = s.split(" ");    
//
//		for ( String ss : arr) {
//		    System.out.println(ss);
//		}
//		
//		
//		
//		String str = "I want to walk my dog";
//		StringTokenizer tokenizer = new StringTokenizer(str);
//
//		while(tokenizer.hasMoreTokens()) {
//		    System.out.println(tokenizer.nextToken());
//		}
//		
//		
//		
//		String mystring = "hi, there,hi Leo";
//		String[] arry = mystring.split("[^a-zA-Z]+");
//		for(int i = 0; i < arry.length; i += 1)
//		{
//		     System.out.println(arry[i]);
//		}
//		
		StringTokenizer separate = new StringTokenizer(s, " ");
		String word = separate.nextToken();
		System.out.println(word);
		
		StringTokenizer st= new StringTokenizer("I want to walk my dog.");
        
        while (st.hasMoreTokens())
            System.out.println(st.nextToken());
 
  
//		int rIndex = name.indexOf("r");
//		//System.out.println(rIndex);
//		String[] str = new String[4];
//		str[0]=name.substring(0, rIndex);
//		
//		int tIndex = name.indexOf("t");
//		str[1]=name.substring(rIndex, tIndex);	
//		
//		int nIndex = name.indexOf("n");
//		str[2]=name.substring(tIndex, nIndex);
//		
//		str[3]=name.substring(nIndex);
//		
//				
//		System.out.println(str[0]);
//		System.out.println(str[1]);
//		System.out.println(str[2]);
//		System.out.println(str[3]);
		
	

	
	
	
	
	}
}
