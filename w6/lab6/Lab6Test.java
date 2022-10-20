package lab6;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class Lab6Test {

  public static int firstUniqChar(String s) {

    HashMap<Character, Integer> appear = new HashMap<Character, Integer>();
    int max = s.length();
    // int test = 0;

    for (int i = 0; i < max; i++) {
      char x = s.charAt(i);
      // put(ket:value) into HashMap
      // since the values are empty it will return default value 0 at the begining
      appear.put(x, appear.getOrDefault(x, 0) + 1);
    }

    // test = appear.getOrDefault('e',0); Testing getOrDefault

    // System.out.println(appear);
    // System.out.println(test);

    for (int j = 0; j < max; j++) {
      if (appear.get(s.charAt(j)) == 1) {

        System.out.println("Output: " + j);
        return j;

      } else {

        System.out.println("Output: " + -1);
        return -1;
      }
    }
    return 0;

  }

  @Test
  public void testFirstUniqChar() {
    // String s = "leetcode";// 0
    assertEquals(0, firstUniqChar("leetcode"));
  }

  public static void main(String[] args) {
    String s = "leetcode";// 0
    // String s = "loveleetcode"; //2
    // String s = "aabb";// -1
    System.out.println("Input s: " + s);
    firstUniqChar(s);

  }
}
