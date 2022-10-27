package A1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest {

  // Implement a sufficient number of tests to have
  // reasonable confidence in the correctness of your
  // PostfixEvaluator implementation.

  @Test
  public void testNormalExecution() {
    PostfixEvaluator expr1 = new PostfixEvaluator("3 4 +"); // define an object of typePostfixEvaluator
    try {
      assertEquals( 7.0, expr1.eval(), 0) ;
    } catch (MalformedExpressionException2 e) {
      fail("THis block should not execute");
    }
  }

  @Test
  public void testFirstInavlidCase() {
    PostfixEvaluator expr1 = new PostfixEvaluator("3 4"); // define an object of typePostfixEvaluator
    try {
      expr1.eval();
      fail("The exception should trigger. It is not the case");
    } catch (MalformedExpressionException2 e) {
    }
  }

  @Test
  public void testFirstInavlidCase2() {
    PostfixEvaluator expr1 = new PostfixEvaluator("3 4 ^"); // define an object of typePostfixEvaluator
    try {
      expr1.eval();
      fail("The exception should trigger. It is not the case");
    } catch (MalformedExpressionException2 e) {
    }
  }

  @Test
  public void testFirstInavlidCase3() {
    PostfixEvaluator expr1 = new PostfixEvaluator("3 4 + *"); // define an object of typePostfixEvaluator
    try {
      expr1.eval();
      fail("The exception should trigger. It is not the case");
    } catch (MalformedExpressionException2 e) {
    }
  }




}
