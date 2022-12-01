package permutationcipher;

public class IllegalKeyException extends Exception {
  public IllegalKeyException(String errorMessage) {
    super(errorMessage);
  }
}
