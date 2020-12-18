package src.main.java;

import java.util.Arrays;

public class Animal {

  static final String[] MY_STATE_VALUES = {"PENDING", "PROCESSING", "PROCESSED"};

  public String[] state() {
    // return a copy of an array
    return Arrays.copyOf(MY_STATE_VALUES, MY_STATE_VALUES.length);
  } 

  public static String iAmDog() {
    return "I am a dog";
  }

  public String getName() {
    return "bob";
  }
}

