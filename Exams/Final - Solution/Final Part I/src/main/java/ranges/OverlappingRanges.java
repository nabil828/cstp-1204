package ranges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverlappingRanges {

  /**
   * Returns the smallest integer that is present in the maximum number of
   * input ranges
   * 
   * @param startPoints
   *                    the list of starting points for the ranges
   * @param endPoints
   *                    the list of end points for the ranges
   * @return the smallest integer that is present in the maximum number of
   *         ranges
   * @throws NoOverlapException
   *                            when there is no overlap between any of the ranges
   */
  public static Integer maxOverlapInt(ArrayList<Integer> startPoints, ArrayList<Integer> endPoints)
      throws NoOverlapException {
    Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();
    int smallest = -1;
    for (int j = 0; j < startPoints.size(); j++) {
      for (int i = startPoints.get(j); i < endPoints.get(j); i++) {
        if (aMap.containsKey(i)) {
          aMap.put(i, aMap.get(i) + 1);
        } else {
          aMap.put(i, 1);
        }
      }
    }

    for (Map.Entry<Integer, Integer> entry : aMap.entrySet()) {
      if (smallest == -1) {
        smallest = entry.getKey();
      } else {
        if (aMap.get(smallest) < entry.getValue()) {
          smallest = entry.getKey();
        } else if (aMap.get(smallest) == entry.getValue()) {
          if (smallest > entry.getKey()) {
            smallest = entry.getKey();
          }
        }
      }
    }

    return smallest;
  }

}
