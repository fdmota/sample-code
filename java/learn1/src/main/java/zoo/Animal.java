package src.main.java.zoo;

// import java.lang.Object;

public abstract class Animal extends Object { // classes automatically extends Object
  protected int age; // bad design patterm

  public static void doIt() {

  }
  
  public abstract void eat();

  protected void age() {
    System.out.println("Age is calculated...");
  }
}
