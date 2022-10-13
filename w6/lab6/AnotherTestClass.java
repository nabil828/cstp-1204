package lab6;

import org.junit.Test;

public class AnotherTestClass {
  @Test
  public static void testAdd() {
    Lab6 lab6 = new Lab6();
    int result = lab6.add(1, 2);
    System.out.println(result);
  }
}
