import java.util.*;

public class W2_demo {

    public static void main(String[] args) {

        List<Integer> aList = new <Integer>LinkedList();
        System.out.println(aList.size()); // 0
        aList.add(1);
        aList.add(1);
        aList.add(1123);
        aList.add(1);
        aList.add(111);aList.add(2323);
        aList.add(123);


        Integer max = Integer.MIN_VALUE;
        for(Integer x : aList){
            max = Math.max(x, max);
        }
        System.out.println(max); // 0

        int [] arrr = new int[1];
        arrr = new int[2];


//        for(int i = 0 ; i < 10; i++){
//            arr[i]= 3;
//        }

    }
}
