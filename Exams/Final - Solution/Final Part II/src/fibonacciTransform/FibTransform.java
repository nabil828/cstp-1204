package fibonacciTransform;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class FibTransform {

  public static boolean isFib(int n) {
        if(n==0){
            return true;
        }
        int fib1 = 0;
        int fib2 = 1;
        while (fib2 < n){
            int saveFib1 = fib1;
            fib1 = fib2;
            fib2 = saveFib1 + fib2;
        }
        return fib2 == n;
    }
	/**
	 * Transform a number into a Fibonacci number using at most m steps: Of
	 * these steps, one can be a doubling step, and the other steps increase
	 * the number at hand by adding 1.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible_onlyOneDoubling(int n, int m) {
		// TODO: Implement this method
		// return false; // change this
    return isPossible_onlyOneDoublingHelper(n, m, false);
	}

  public static boolean isPossible_onlyOneDoublingHelper(int n, int m, boolean hasDoubled) {
    if(isFib(n))
        return true;

    if(m==0)
        return false;
    
    if(hasDoubled)
        return isPossible_onlyOneDoublingHelper(n+1, m-1, hasDoubled);
    else
        return isPossible_onlyOneDoublingHelper(n*2, m-1, true) || isPossible_onlyOneDoublingHelper(n+1, m-1, hasDoubled);
  }

	/**
	 * Transform a number into a Fibonacci number using at most m steps: One can
	 * use any sequence of doubling (*2) or addition (+1) steps as long as the
	 * total number of steps used is no more than m.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible(int n, int m) {
		// TODO: Implement this method
    if(isFib(n))
        return true;

    if(m==0)
        return false;
    
    return isPossible(n*2, m-1) || isPossible(n+1, m-1);
		// return false; // change this
	}

}
