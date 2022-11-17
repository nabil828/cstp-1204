package w11;

// public abstract class GameObject {
//   public abstract void draw();
// }

public interface GameObject {
  public void draw();
}

class Rectangle implements GameObject {
  public void draw() {
    System.out.println("Rectangle");
  }

  public static void main(String[] args) {
    GameObject[] arr = new GameObject[3];
    // arr[0] = new GameObject();
    arr[0] = new Triangle();
    arr[1] = new Triangle();
    arr[2] = new Rectangle();

    for (GameObject x : arr) {
      x.draw();
    }

  }
};

class Triangle implements GameObject {
  public void draw() {
    System.out.println("Triangle");
  }
};