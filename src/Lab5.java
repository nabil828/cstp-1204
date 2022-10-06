public class Lab5 {
    public static void main(String[] args) {
        System.out.println(dayOfYear(26, 22, 2022)); // should fail fast
    }

    private static int dayOfYear(int month, int dayOfMonth, int year) {
        // fail fast -todo
        if (month < 1 || month > 12)
            throw new IllegalArgumentException();

        int[] monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += monthLengths[i - 1];
        }
        sum += dayOfMonth;
        return sum;
    }
}
