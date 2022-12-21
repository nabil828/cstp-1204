package Helpers;

import java.util.Comparator;

public class VertexDistanceComparator implements Comparator<shortestDistanceHelper>{

    @Override
    public int compare(shortestDistanceHelper arg0, shortestDistanceHelper arg1) {
        if(arg0.distance < arg1.distance){
            return -1;
        }else{
            return 1;
        }
    }

}
