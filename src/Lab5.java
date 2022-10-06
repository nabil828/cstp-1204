public class Lab5 {
    public static void main(String[] args) {
        System.out.println(dayOfYear(6, 22, 2022)); // 173
        System.out.println(dayOfYear(10, 6, 2022)); // 279
    }

    private static int dayOfYear(int month, int dayOfMonth, int year) {
        int[] monthLengths = new int[] { 31, 28, 31, 30, 31, 30, 31 , 31, 30 , 31, 30,  31 };
        int sum = 0;
        for(int i= 1; i < month ; i++){
            sum += monthLengths[i-1];
        }
        sum += dayOfMonth;
        return sum;
    }
}
