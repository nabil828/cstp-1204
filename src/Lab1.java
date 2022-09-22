public class Lab1 {
    static   void  shifting(int []arr, int stop_index ){
        for(int j = arr.length - 1; j >  stop_index; j--){
            arr[j] = arr[j -1];
        }
    }
    public static void main(String[] args) {

        int [] arr = {1,0,2,3,0,4,5,0};
        for( int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i] == 0){
                shifting(arr, i + 1);
                arr[i + 1] = 0;
                i++;
            }
        }
        // output
        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);   // [1, 0, 0, 2, 3, 0, 0, 4]
        }

    }
}
