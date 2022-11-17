package sortasquares;

import java.util.Set;
import java.util.HashSet;

public class SortaSquare {

    /**
     * Return a subset of SortaSquares from the integers in set s.
     * 
     * @param s
     *            the set from which we want to extract SortaSquares
     * @return a subset with all the SortaSquares in s
     */
    public static Set<Integer> getSortaSquares(Set<Integer> s) {
        // TODO: Implement this method
        Set<Integer> resultSet = new HashSet<Integer>();
        for (Integer x : s) {
            if (check(x)) {
                resultSet.add(x);
            }
            ;
        }
        // return new HashSet<Integer>();
        return resultSet;
    }

    private static boolean check(Integer x) {
        boolean result = false;
        int n = -1;
        int b = (int) Math.sqrt(x);
        while (b > 0) { // my stopping criteria
            int a = 1;
            while (a < b) {
                n = a * b * b;
                if (n == x) {
                    result = true;
                    break;
                }
                a++;
            }
            b--;
        }
        return result;
    }
}
