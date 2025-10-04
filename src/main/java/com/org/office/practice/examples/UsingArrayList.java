package com.org.office.practice.examples;
import java.util.*;


public class UsingArrayList {
	
	
public static void main(String[] args) {
	List<String> al = new ArrayList<>();
	al.add("hi");
	al.add("sai");
	al.set(1, "sai sha"); //set is used to update data
	
	System.out.println("empty or not :" + al.isEmpty());
	System.out.println("showing : " + al);
	
	//declaring arraylist with initial size n
	
ArrayList<Integer> a1 = new ArrayList<Integer>();
for (int i = 1; i <= 5; i++) a1.add(i);
System.out.println("new int array :" + a1);
	
//remove element at index 3
a1.remove(3);
System.out.println("removed 3rd element at index :" +a1);

//print element one by one

for (int i =0; i< a1.size(); i++) 
	System.out.println("showing one by one : " + a1.get(i) + " ");


//string in arraylist 

ArrayList<String> ve = new ArrayList<>();
ve.add("car");
ve.add("bike");
ve.add("cycle");
ve.add("auto");
ve.add("van");
ve.add("truck");
ve.add("car"); // arraylist allows duplicate values

String a2= ve.get(2);

System.out.println("size of list:" + ve.size());
System.out.println("last index of:" + ve.lastIndexOf("car"));
System.out.println("String:" + a2);
System.out.println(":" + ve.contains("car"));
System.out.println("show:"+ ve);
System.out.println("present or not : " + ve.indexOf("bus")); //result should be -1 
			//because there is no "bus" present in the given Arraylist




List l = new ArrayList();
l.add(0,100);
l.add(200);
l.add(300);
l.add(200);
System.out.println("result =" + l);

ArrayList alist = new ArrayList ();
alist.add("nandhini");
alist.add(28);
alist.add("female");
alist.add("A neg");
System.out.println(alist);


//queue with linked list  
//queue is FIFO 
Queue<Integer> q = new LinkedList<>();
q.add(3);
q.add(5);
q.add(4);
q.add(8);

System.out.println("head of queue is: " + q.peek());//head of queue 

System.out.println(q.poll()); // removed head of queue--> (3)

System.out.println(q);




}
}

