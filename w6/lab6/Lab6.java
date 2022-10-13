package lab6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lab6 {
  public static void main(String[] args) {
    System.out.println("Hello World!666666");
    System.out.println(add(1, 2)); // 3
  }

  public static int add(int a, int b) {
    return a + b;
  }

  public static int mul(int a, int b) {
    return a * b;
  }

  public static int div(int a, int b) {
    return a / b;
  }

  @Test
  public void mulTest() {
    assertEquals(2, mul(1, 2));
    assertEquals(2, mul(2, 2));
  }
}
