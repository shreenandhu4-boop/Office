package com.org.office.practice.revision;

public class Book {					//constructor examples
	   String title;
	   String author;
	
	// String color;
	  //  int price;

	    // Explicit default constructor
	    public Book() {  // -----> this constructor takes no arguments
	        this.title = "Unknown Title";
	        this.author = "Unknown Author"; //--> providing default values for new book objects
	        
	        // when new book() is called in main this specific constructor is invoked
	        
	        System.out.println("Book object created using the explicit default constructor.");
	    }
	    
	    public static void main(String[] args) {
	        // Creating an object using the explicit default constructor
	        Book myBook = new Book();
	        System.out.println("Book Title: " + myBook.title);
	        System.out.println("Book Author: " + myBook.author); 
	    	 
	         // Instance variables will be initialized to their default values (null for String, 0 for int)
	       /*  System.out.println("Pen Color: " + myBook.color);
	           System.out.println("Pen Price: " + myBook.price); */
	}
}