package numberlinetravel;

import java.util.HashSet;
import java.util.Set;

public class NumberLineTravel {

    /**
	 * Determine how many unique cities you can visit via monorail if you are
	 * limited to k kilometers per trip. You are permitted an infinite number of
	 * trips. You are given an array that represents city locations and you
	 * start your journey at the first city in the array.
	 * 
	 * @param x
	 *            is an array that represents the cities on a number line. The
	 *            distance between city x[i] and city x[j] is | x[i]-x[j] |
	 *            kilometers.
	 * @param k
	 *            represents the maximum distance, in kilometers, that one can
	 *            travel in one monorail trip. k should be greater than 0.
	 * @return the number of new cities that one can visit starting from x[0].
	 *         x[0] is not included in the count.
	 */
	public static int howManyCitiesCanIVisit(int[] x, int k) {
		// TODO: Implement this method
	    Set<Integer> vistedSet = new HashSet<Integer>();
	    vistedSet.add(x[0]);
	    int currentCity = x[0];
	    for (int i =1 ; i <x.length; i++){
	        if(valid(x[i], k , vistedSet) && !vistedSet.contains(x[i])){
	            currentCity = x[i];
	            vistedSet.add(x[i]);
	            i=0;
	        }
	    }
		return vistedSet.size()-1;
	}

    private static boolean valid(int i, int k, Set<Integer> vistedSet) {
        boolean result = false;
        for(int yCity : vistedSet){
            if (Math.abs(i - yCity) <=k){
                result = true;
            }
        }
        
        return result;
    }

}
