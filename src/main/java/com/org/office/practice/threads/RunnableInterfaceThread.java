package com.org.office.practice.threads;

//using "implements Runnable" interface instead of "extends Thread"
//it is used to implement two or more class 
class Sample implements Runnable{
	public void run() {
		System.out.println("hey hello...");
	}
}

public class RunnableInterfaceThread {
	public static void main(String[] args) {
		Runnable objSam = new Sample(); // instead of using "Sample" we can also use "Runnable" to create an object
		
		Thread t1 = new Thread(objSam); // here we are calling run()method with in the thread
		t1.start();  // start function cannot use without thread
	}

}
