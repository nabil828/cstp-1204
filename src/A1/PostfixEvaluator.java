package A1;

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
  double eval() throws MalformedExpressionException2 {
    Scanner scanner = new Scanner(arithmeticExpr);
    Stack<Double> tokenStack = new Stack<>();
    while (!scanner.isEmpty()) {
      Token currToken = scanner.getToken();
	  if(currToken.isDouble()){
		  tokenStack.push(currToken.getValue());
	  }else{
          if(tokenStack.size() < 2)
              throw new MalformedExpressionException2("");

		  Double x = tokenStack.pop();
		  Double y = tokenStack.pop();
		  if(currToken.equals( "+"))
			  tokenStack.push(y + x);
		  else if (currToken.equals("-"))
			  tokenStack.push(y - x);
		  else if (currToken.equals("/"))
		  tokenStack.push(y / x);
		  else if (currToken.equals("*"))
			  tokenStack.push(y * x);
          else
              throw new MalformedExpressionException2("");
	  }
      scanner.eatToken();
    }
    if(tokenStack.size() > 1)
        throw new MalformedExpressionException2("");
    return tokenStack.peek();
  }
}