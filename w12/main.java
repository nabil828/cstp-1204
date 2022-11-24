package w12;

import javax.sound.sampled.SourceDataLine;

public class main {

  static void vertical_numbers_recursive(int n) {
    if (n < 10)
      System.out.println(n);
    else {
      vertical_numbers_recursive(n / 10); // all except the last digit
      System.out.println(n % 10); // last digit
    }
  }

  static void vertical_numbers_iterative(int n) {
    int X = (int) Math.pow(10, (((int) (Math.log10(n) + 1)) - 1));
    while (n != 0) {
      System.out.println(n / X);
      n = n % X;
      X /= 10;
    }
  }

  static int fibonacci_recursive(int n) {
    if (n == 0 || n == 1)
      return n;
    else
      return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
  }

  static final int max = 10000;
  static int[] cache = new int[max];

  static int fibonacci_recursive_dp(int n) {
    if (n == 0 || n == 1)
      return n;
    else {
      if (cache[n] != 0) {
        return cache[n];
      } else
        cache[n] = fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
      return cache[n];
    }
  }

  static int fibonacci_iterative(int n) {
    Integer[] arr = new Integer[n + 1];
    for (int i = 0; i <= n; i++) {
      if (i == 0 || i == 1)
        arr[i] = i;
      else
        arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[n];
  }

  public static void main(String[] args) {
    int x = 1234;
    // vertical_numbers_recursive(x);
    // vertical_numbers_iterative(x);
    // System.out.println(fibonacci_recursive(19)); // expected return : 4181
    // System.out.println(fibonacci_iterative(19)); // expected return : 4181

    int n = 40;
    System.out.println("Fibonacci iteration:");
    long start = System.currentTimeMillis();
    System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibonacci_iterative(n));
    System.out.printf("Time: %d ms\n", System.currentTimeMillis() - start);

    System.out.println("Fibonacci recursive:");
    start = System.currentTimeMillis();
    System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibonacci_recursive(n));
    System.out.printf("Time: %d ms\n", System.currentTimeMillis() - start);

    System.out.println("Fibonacci recursive:");
    start = System.currentTimeMillis();
    System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibonacci_recursive_dp(n));
    System.out.printf("Time: %d ms\n", System.currentTimeMillis() - start);

  }
}
