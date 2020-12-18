package src.main.java.zoo;

import src.main.java.Loggable;
import src.main.java.Printable;

public class Dog extends Animal implements Loggable, Printable {

	public String message() {
		// TODO Auto-generated method stub
		return null;
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		System.out.println("Dog is eating...");
	}

	@Override
  public void age() { // extend visibility
		System.out.println("Dog is 11");
	}

	@Override
	public void finalize() {
		System.out.println("finalize");
	}

	@Override
	public String toString() {
		return "toString dog class";
	}
}
