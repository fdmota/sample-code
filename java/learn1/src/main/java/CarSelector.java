package src.main.java;

public class CarSelector {
  public static void main(String[] arguments) {
    CarService carService = new CarService();
    for (String arg : arguments) {
      if (isValid(arg)) {
        carService.process(arg);
      } else {
        System.out.println("ignoring invalid argument: " + arg);
      }
      /* option 2
      try {
        carService.process(arg);
      } catch (RuntimeException e) {
        e.printStackTrace();
        System.err.println(e.getMessage());
      }
      */
    }
    carService.drive();
  }

  private static boolean isValid(String arg) {
    try {
      CarState carState = CarState.valueOf(arg);
    } catch (IllegalArgumentException e) {
      // e.printStackTrace();
      // System.err.println(e.getMessage());
      return false;
    } finally {
      // do something
    }
    return true;
  }
}
