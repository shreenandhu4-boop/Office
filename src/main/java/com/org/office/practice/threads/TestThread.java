package com.org.office.practice.threads;
class Demo implements Runnable{
	private String threadName;
	Demo(String name){
		threadName = name;
		System.out.println("thread: " + threadName + " , " + "state: new" );
	}
	public void run() {
		System.out.println("thread: " + threadName + "," + "state: running");
		for (int i=4; i>0; i--) {
			System.out.println("thread:" + threadName + "," + i);
		}
		System.out.println("thread "+ threadName + "," + "state: Dead");
		
	}
}
public class TestThread {
	public static void main(String[] args) {
		Demo demo1 = new Demo("thread-1");
		Demo demo2 = new Demo("thread-2");
		
		Thread thread1 = new Thread(demo1);
		Thread thread2 = new Thread(demo2);
		 
		thread1.start();
		thread2.start();
		
		
	}

}
