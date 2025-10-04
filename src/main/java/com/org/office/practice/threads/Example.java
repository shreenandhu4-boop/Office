package com.org.office.practice.threads;


class A extends Thread{
	public void run() {  //thread must have run() function/method   with public  
		for(int i=0; i<20; i++) {
		System.out.println("hey hello");
		try {							//default exception handiling (try,catch)
			Thread.sleep(10); // ----> sleep is used to pause thread for 10 millisecond
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}					//threads are used to run multiple times 
}						//here class A and class B are running at the same time

class B extends Thread{
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println("ok bye");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			}
		}
	}
public class Example {
	public static void main(String[] args) {
		A a1= new A();
		B b1 = new B();
		
		b1.setPriority(10);  // first priority goes to B method
		a1.setPriority(2);
		
		
		a1.start();   // to start thread
		b1.start();
	}

}
