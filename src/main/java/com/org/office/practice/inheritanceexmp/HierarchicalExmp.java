package com.org.office.practice.inheritanceexmp;

public class HierarchicalExmp {
	public static void main(String[] args)
    {
        Bb objBb = new Bb();
        objBb.printAa();
        objBb.printBb();

        Cc objCc = new Cc();
        objCc.printAa();
        objCc.printCc();

        Dd objDd = new Dd();
        objDd.printAa();
        objDd.printDd();
    }

}
