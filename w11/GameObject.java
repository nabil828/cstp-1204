package w11;

public class GameObject {
  public void draw() {
    System.out.println("GameObject");
  }

  public static void main(String[] args) {
    GameObject[] arr = new GameObject[3];
    arr[0] = new GameObject();
    arr[1] = new Triangle();
    arr[2] = new Rectangle();

    for (GameObject x : arr) {
      x.draw();
    }

  }
}

class Rectangle extends GameObject {

  public void draw() {
    System.out.println("Rectangle");
  }
};

class Triangle extends GameObject {

  public void draw() {
    System.out.println("Triangle");
  }
};