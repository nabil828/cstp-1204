package lab6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Lab6Test {
  @Test
  public void testAdd() {
    Lab6 lab6 = new Lab6();
    int result = lab6.add(1, 2);
    System.out.println(result);
    assertEquals(2, result);
    // assertTrue(true);
  }
}
