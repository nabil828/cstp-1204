import java.util.Stack;

/**
 * 
 * 
 * This class contains a method to evaluate an arithmetic expression
 * that is in Postfix notation (or Reverse Polish Notation).
 * See
 * <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Wikipedia</a>
 * for details on the notation.
 *
 */
public class PostfixEvaluator {

  private String arithmeticExpr;

  /**
   * This is the only constructor for this class.
   * It takes a string that represents an arithmetic expression
   * as input argument.
   * 
   * @param expr is a string that represents an arithmetic expression
   *             <strong>in Postfix notation</strong>.
   */
  public PostfixEvaluator(String expr) {
    arithmeticExpr = expr;
  }

  /**
   * This method evaluates the arithmetic expression that
   * was passed as a string to the constructor for this class.
   * 
   * @return the value of the arithmetic expression
   * @throws MalformedExpressionException if the provided expression is not
   *                                      a valid expression in Postfix notation
   */
  double eval() throws MalformedExpressionException {
    // TODO: Implement this method.
    // The code provided here is for illustration only, and
    // can be deleted when you write your implementation.

    // Using a stack makes it very simple to evaluate the
    // arithmetic expression.
    // See http://docs.oracle.com/javase/8/docs/api/java/util/Stack.html

    // Use the Scanner to get the elements (tokens) in the
    // arithmetic expression.

    // Scanner scanner = new Scanner(arithmeticExpr);
    // Token currToken = scanner.getToken();

    // now process the token, etc.
    // You should read the implementation of the Token class
    // to determine what methods you can and should use.

    // It is sufficient to support the four basic operations:
    // addition, subtraction, multiplication & division.

    // Evaluate postfix
    Scanner scannerObj = new Scanner(arithmeticExpr);
    // Token currentToken = scannerObj.getToken();
    Stack<String> postfixItemsStack = new Stack<String>();

    while (!scannerObj.isEmpty()) {
      // Token currentToken = scannerObj.useToken(scannerObj.getToken().toString());
      Token currentToken = scannerObj.getToken();
      scannerObj.eatToken();
      if (currentToken.isDouble()) {
        postfixItemsStack.push(currentToken.toString());
      } else {
        // If there are fewer than n values on the stack
        if (postfixItemsStack.size() < 2) {
          throw new MalformedExpressionException();
        } else {
          // Else, Pop the top n values from the stack.
          Double operand2 = Double.parseDouble(postfixItemsStack.pop());
          Double operand1 = Double.parseDouble(postfixItemsStack.pop());
          // Evaluate the operator, with the values as arguments
          Double result = 0.0;
          switch (currentToken.toString()) {
            case "+":
              result = operand1 + operand2;
              break;
            case "-":
              result = operand1 - operand2;
              break;
            case "*":
              result = operand1 * operand2;
              break;
            case "/":
              result = operand1 / operand2;
              break;
            default:
              throw new MalformedExpressionException();
          }
          // Push the returned results, if any, back onto the stack.
          postfixItemsStack.push(Double.toString(result));

        }
      }

    }
    double result = 0.0;
    if (postfixItemsStack.size() == 1) {
      result = Double.parseDouble(postfixItemsStack.pop());
      // System.out.println("The result is "+ postfixItemsStack.pop());
    } else {
      throw new MalformedExpressionException();
    }
    return result;
  }

}