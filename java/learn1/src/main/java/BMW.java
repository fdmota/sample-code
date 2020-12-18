package src.main.java;

public class BMW implements Car, Loggable, Property, Asset {

	public void drive() {
    System.out.println("BMW driving...");
	}

  public int value() {
    return 80000;
  }

  public String owner() {
    return "Filipe";
  }

  public String message() {
    return "BMW " +  owner() + " " + value();
  }
}
