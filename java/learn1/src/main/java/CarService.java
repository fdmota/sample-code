package src.main.java;

public class CarService {

  public void process(String input) {
    System.out.println("input: " + input);
    CarState carState = CarState.from(input);
    System.out.println("Valid state: " + input);
  }

  public void drive() {
    Car bmw = new BMW();
    Car porsche = new Porsche();
    Car mercedes = new Mercedes();

    bmw.drive();
    porsche.drive();
    mercedes.drive();

    Car[] cars = {new BMW(), new Porsche(), new Mercedes()};
    for(Car car: cars) {
      car.drive();
    }
  }
}
