package com.org.office.practice.revision;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMaps {
	
	public static void main(String[] args) {
		
	Map<String, Integer> hm = new LinkedHashMap<>();
	hm.put("nandhini", 28);
	hm.put("saisha", 3);
	hm.put("dhakshwin", 4);
	hm.put("anikha", 6);
	hm.put("manigandana", 32);
	
	System.out.println("show list: " +hm);
	System.out.println("showing list line by line");
	for(Map.Entry<String, Integer> me : hm.entrySet())
	{
		
		System.out.println(me.getKey()+ ":" + me.getValue());
	}
	
	}
}
