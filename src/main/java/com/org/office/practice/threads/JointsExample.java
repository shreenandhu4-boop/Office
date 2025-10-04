package com.org.office.practice.threads;


class Aa extends Thread
{
	int j=0;
	public void run() {
		for(int i=0; i<20; i++) {
			j=i;
			
		}
	}
}


public class JointsExample {
	public static void main(String[] args) {
		
		Aa a1 = new Aa();
		a1.start();  //thread started
		try {
			a1.join();     // join() is used to wait untill the thread finish
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println(a1.j);  // after finishing thread this line will be executed 
	}

}
