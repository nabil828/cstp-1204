import java.util.*;

public class Map {
  public static void main(String[] args) {
    HashMap<String, Integer> myFirstMap = new HashMap<String, Integer>();
    myFirstMap.put("a", 1);
    myFirstMap.put("b", 2);
    myFirstMap.put("c", 3);
    myFirstMap.remove("b");
    System.out.println(myFirstMap.size()); // 2
    System.out.println(myFirstMap.get("a")); // 1
    System.out.println(myFirstMap.get("b")); // null
    System.out.println(myFirstMap.get("c")); // 3
    System.out.println(myFirstMap.containsKey("a")); // true
    for (String key : myFirstMap.keySet()) {
      System.out.println(key);
      System.out.println(myFirstMap.get(key));
    }
    for(HashMap.Entry<String, Integer> entry : myFirstMap.entrySet()) {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }


  }
}
