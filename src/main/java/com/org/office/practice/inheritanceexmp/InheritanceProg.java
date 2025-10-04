package com.org.office.practice.inheritanceexmp;

public class InheritanceProg {
public static void main(String[] args) {
	A objA = new A();
	objA.m1PresentInClassA();
	objA.m2PresentInClassA();
	
	objA.m1PresentInClassB();
	objA.m1PresentInClassB();
	objA.m1PresentInClassC();
	objA.m2PresentInClassC();
}
}
