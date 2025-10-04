package com.org.office.practice.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class UsingMap {

	/* faster access and search
	 * dont care about order of elements
	 */
	//hash map is faster than hash set
	public static void main(String[] args) {
	Map<String, Integer> m =new LinkedHashMap<>();
	m.put("apple", 30);
	m.put("orange", 20);
	m.put("papaya", 10); // put method to add elements
	m.put("banana", 60);
	System.out.println(m);
	
	/* hashmap supports multiple values but only one null key
	 * it use BUCKETS for its implementation
	LinkedHashMap uses double linked buckets */
	
	Map<String, Integer> hm =new HashMap<String, Integer>();
	hm.put("a", 100);
	hm.put("b",200);
	hm.put("c",00);
	hm.put("d", 400);
	for(Map.Entry<String, Integer> me : hm.entrySet())
	{
		System.out.println(me.getKey()+ ":");
		System.out.println(me.getValue());
	}
									// treeset and treemap --> null not allowed
	
	TreeMap<Integer, String> ts = new TreeMap<>();
	ts.put(1, "hi");
	ts.put(5, "good morning");
	ts.put(18, "good afternoon");
	ts.put(11, "hello");
	ts.put(2, "welcome");    //natural sorting order based on key put(k,v)
	System.out.println(ts); // ( k--->key, v---> value)

	System.out.println("ceiling entry : " + ts.ceilingEntry(1));
	System.out.println("tail map  : " + ts.tailMap(11, false));
	
	
	
	}
}
