package w11;

class B {
  public A obj;

  B() {
    System.out.println("B Constructor");
  }

  public static void main(String[] args) {
    B obj = new B();
  }

  public boolean equals(B anotherObject) {
    if (anotherObject == null)
      return false;
    else if (this.obj.x != anotherObject.obj.x)
      return false;
    else
      return true;
  }

};