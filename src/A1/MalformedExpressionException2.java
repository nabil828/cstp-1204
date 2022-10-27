package A1;

/**
 * Exception thrown when an invalid arithmetic expression is encountered
 * by the program. The message field contains information about the
 * particular problem that was encountered.
 *
 * @see #getMessage()
 */

public class MalformedExpressionException2 extends Exception {

  /**
   * Constructs a MalformedExpressionException with no message.
   */
  public MalformedExpressionException2() {
    super();
  }

  /**
   * Constructs a MalformedExpressionException with the detail message.
   */
  public MalformedExpressionException2(String message) {
    super(message);
  }
}