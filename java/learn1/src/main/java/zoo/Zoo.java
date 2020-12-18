package src.main.java.zoo;

public class Zoo {
  
  public static void main(String[] args) {
    run();
  }

  public static void run() {
    Animal[] animals = {new Dog(), new Gorilla(),};
    feedAnimals(animals);
  }

  public static void feedAnimals(Animal[] animals) {
    Animal.doIt(); // static method
    for(Animal animal: animals) {
      animal.eat();
      animal.age();
      System.out.println(animal.toString());
    }
  }
}
