public class Lab5 {
    public static void main(String[] args) {
        System.out.println(dayOfYear(Month.JUNE, 22, 2022)); // should fail fast
        System.out.println(Month.JUNE.ordinal() + 1);
    }
    public static enum Month { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST,
        SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER}
    private static int dayOfYear(Month month, int dayOfMonth, int year) {

        int[] monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for (int i = 1; i < month.ordinal() + 1; i++) {
            sum += monthLengths[i - 1];
        }
        sum += dayOfMonth;
        return sum;
    }
}
