import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class HelloWorld {
    static void f1(){
        System.out.println("f1 has been exectued!");
    }
    public static void main(String[] args) {
//        Set<Integer> x = new HashSet<>();
        MySet x = new MySet();
        x.add(11);
        x.add(12);
        x.add(13);
        x.add(14);
        x.add(15);
        x.remove(11);

        System.out.println(x.size()); // 4
        System.out.println(x.contains(11)); // false


//        long yy = 2957394534957395739573873;
//        System.out.println(yy);
    }
}
