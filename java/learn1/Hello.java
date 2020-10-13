import java.util.ArrayList;

class Hello {
  public static void main(String[] args) {
      System.out.println("Hello, World.");
      String name = "Filipe";
      System.out.println( name.hashCode() + " is learning JAVA");
      addExclamationPoint(name);
      System.out.println(addExclamationPoint2(name));

      // Animal a = new Animal();
      String s = Animal.iAmDog();
      System.out.println(s);
      
      ArrayList<Integer> a = new ArrayList<Integer>();
      System.out.println(a.size());
      a.add(1);
      a.add(2);
      a.add(3);
      System.out.println(a);
  }

  public static void addExclamationPoint(String s) {
    System.out.println(s + "!");
  }

  public static String addExclamationPoint2(String s) {
    return s + "!!";
  }
}
