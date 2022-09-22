public class Lab2PlusOne {
    public static void main(String[] args) {
        int [] arr =  {1, 2, 3}; // {1, 2, 4}
//        int [] arr =  {4,3,2,1}; // // {4, 3, 2, 2}
//        int [] arr =  {9}; // {1, 0}
//        int [] arr =  {9,0,9,0}; // {9,0,9,1}
//        int [] arr =  {9,9}; // {1, 0, 0}

        // logic
       arr = solution(arr);

           for(int i : arr)
               System.out.println(i);

    }

    private static int[] solution(int[] arr) {
        int i;
        for (i = arr.length -1 ; i >= 0; i--){
            if(arr[i] != 9 ) {
                arr[i]++;
                return arr;
            }else{
                // it is a 9!
                arr[i] = 0;

            }
        }
        // if I reached this point, I have seen a 9
        if(arr[i+1] == 0) {
            //increase the size of the array by one and ADD 1
            int [] tmp = new int[arr.length + 1];
            for(int j = 0; j < arr.length ; j++){
                tmp [j+ 1] = arr[j];
            }
            tmp[0] =1;
            arr = new int[tmp.length];
            for(int j = 0; j < arr.length ; j++){
                arr [j] = tmp[j];
            }
        }

        return arr;
    }
}
