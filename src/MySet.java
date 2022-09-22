public class MySet {
    int [] arr ;
    int size;
    MySet(){
        size = 0;
        arr = new int[100] ;
    }
    void add(int a){
        for(int i = 0 ; i < size ; i++)
            if(arr[i] == a)
                return;
        arr[size++] = a;
    }

    int size(){
        return size;
    }

    void remove(int target) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                //shifting
                for (int j = i; j < size; j++) {
                    arr[j] = arr[j + 1];
                }
                size--;
            }

        }
    }

    boolean contains(int target){
        for(int i = 0; i < size ; i++){
            if(arr[i] == target)
                return true;
        }
        return false;
    }
}
