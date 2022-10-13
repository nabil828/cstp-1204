import java.util.LinkedList;
import java.util.Queue;

public class QueueIntro {
  public static void main(String[] args) {
    Queue<Integer> myFirstQueue = new LinkedList<Integer>();
    myFirstQueue.add(1);
    myFirstQueue.add(2);
    myFirstQueue.add(3);
    myFirstQueue.add(4);

    System.out.println(myFirstQueue.peek()); // 1
    System.out.println(myFirstQueue.poll()); // 1
    System.out.println(myFirstQueue.peek()); // 2
    myFirstQueue.isEmpty(); // false

  }
}
