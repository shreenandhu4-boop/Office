package com.org.office.practice.polymorphismexmp;

class Animals{
	void animalSound() {
		System.out.println("the animal makes a sound");
	}
}

class Pig extends Animals{
	void animalSound() {
		System.out.println("the pig says: wee wee");
	}
}

class Dogs extends Animals{
	void animalSound() {
		System.out.println("the dog says: bow bow");
	}
}



public class Example2 {
	public static void main(String[] args) {
		Animals myAnimals = new Animals();
		Animals myPig = new Pig();
		Animals myDogs = new Dogs();
		
		myAnimals.animalSound();
		myPig.animalSound();
		myDogs.animalSound();
		
	}

}
