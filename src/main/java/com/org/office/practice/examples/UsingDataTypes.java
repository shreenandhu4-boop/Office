package com.org.office.practice.examples;

public class UsingDataTypes {
	public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;	//boolean data type to display true or false values.

        System.out.println("Is your day good? " + b1);  
        System.out.println("Is fish tasty? " + b2); 
        
        /*The byte data type is useful for saving memory in large arrays.
         *  byte data type to display small integer values.
         *   1 byte (8 bits)
         */
        
        byte a = 25;
        byte t = -10;

        System.out.println("Age: " + a);  
        System.out.println("Temperature: " + t); 
        
        /*short data type to store moderately small integer value.
         * 2 bytes (16 bits)
         */
        
        short num = 1000;
        short temp = -200;

        System.out.println("Number of Students: " + num);  
        System.out.println("Temperature: " + temp);
        
        /* long data type to store large integer value
         * offering a much broader range.
         */
        
        long w = 7800000000L;
        long l = 9460730472580800L;

        System.out.println("World Population: " + w);  
        System.out.println("Light Year Distance: " + l);
        
        /*
         * char data type to store individual characters.
         */
        
        char g = 'A';
        char s = '$';

        System.out.println("Grade: " + g); 
        System.out.println("Symbol: " + s); 
        
        /*create and access elements of an array.
         * array starts with 0,1,2..
         */
        
        int[] numb = {1, 2, 3, 4, 5, 6};
        String[] arr = {"anikha", "dhakshwin", "lily", "saisha"};

        System.out.println(" Number: " + numb[3]);  
        System.out.println("Name : " + arr[2]);
    }

}
