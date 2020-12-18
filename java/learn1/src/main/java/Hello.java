package src.main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.util.ContextInitializer;

import java.util.ArrayList;

class Hello {
  public static void main(String[] args) {
      byte myByte = 3;
      char myChar = 'a';

      System.out.println("args: " + args);


      // Logger
      System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "src/main/resources/logback.xml");
      Logger logger = LoggerFactory.getLogger(Hello.class);
      
      logger.debug("Debug Hello World {}", "arg1"); // best method
      logger.info("Info Hello World");
      if (logger.isWarnEnabled()) { // not so good method
        logger.warn("Warn Hello World");
      }
      logger.error("Error Hello World");

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

      // Arrays
      int[] myInts = new int[7];
      System.out.println(myInts.length);
      Animal[] myAnimals = new Animal[7];
      for(int i = 0; i < myAnimals.length; i++) {
        myAnimals[i] = new Animal();
      }
      // Foreach
      for(Animal animal : myAnimals) {
        System.out.println(animal.getName());
      }
      System.out.println(myAnimals.getClass());

      // Array defined with {}
      final Animal[] myAnimals2 = {
        myAnimals[0], 
        null, 
        myAnimals[6], // trailing comma
      };
      System.out.println("lenght: " + myAnimals2.length);
      
      // final static enum
      // LoggingLevel state = LoggingLevel.PENDING;
      for(LoggingLevel state : LoggingLevel.values()) {
        System.out.println(state.code());
        // if (state.equals(LoggingLevel.PENDING)) {
        //   System.out.println("It is pending");
        // }
        switch(state) {
          case PENDING:
            System.out.println("It is pending");
            break;
          case PROCESSED:
          case PROCESSING:
            System.out.println("It is processed or processing");
            break;
          default:
            throw new Error("Unknown state");
        }
      }

    // https://www.youtube.com/watch?v=grEKMHGYyns
    // 5:46:54
    // Read effective Java book by Joshua Bloch
  }

  public static void addExclamationPoint(String s) {
    System.out.println(s + "!");
  }

  public static String addExclamationPoint2(String s) {
    return s + "!!";
  }
}
