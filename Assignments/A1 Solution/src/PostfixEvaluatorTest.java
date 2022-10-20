import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest {

	// Implement a sufficient number of tests to have
	// reasonable confidence in the correctness of your
	// PostfixEvaluator implementation.
	
	@Test
	public void testNormal() {
	    PostfixEvaluator PostfixEvaluatorObj = new PostfixEvaluator("1 5 +");
        
	    try {
            assertEquals(PostfixEvaluatorObj.eval(), 6.0, 0);
        } catch (MalformedExpressionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//		fail("Not yet implemented");
	}
	@Test
	public void testExtraChar() {
        PostfixEvaluator PostfixEvaluatorObj = new PostfixEvaluator("1 5 + *");
        
        try {
            double result = PostfixEvaluatorObj.eval();
            fail();
        } catch (MalformedExpressionException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
//          fail("Extra operation");
        }
//	      fail("Not yet implemented");
    }
	
   @Test
    public void testExtraOperand() {
        PostfixEvaluator PostfixEvaluatorObj = new PostfixEvaluator("1 5 6 +");
        
        try {
            double result = PostfixEvaluatorObj.eval();
            fail();
        } catch (MalformedExpressionException e) {
            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	          fail("Extra operation");
        }
//	        fail("Not yet implemented");
    }
   
   @Test
   public void testTwoOperandsWithoutOperator() {
       PostfixEvaluator PostfixEvaluatorObj = new PostfixEvaluator("1 5");
       
       try {
           double result = PostfixEvaluatorObj.eval();
           fail();
       } catch (MalformedExpressionException e) {
           // TODO Auto-generated catch block
//             e.printStackTrace();
//           fail("Extra operation");
       }
//         fail("Not yet implemented");
   }
   
   
   @Test
   public void testSubOperationsWithoutOperator() {
       PostfixEvaluator PostfixEvaluatorObj = new PostfixEvaluator("1 5 + 4 7 *");
       
       try {
           double result = PostfixEvaluatorObj.eval();
           fail();
       } catch (MalformedExpressionException e) {
           // TODO Auto-generated catch block
//             e.printStackTrace();
//           fail("Extra operation");
       }
//         fail("Not yet implemented");
   }
   
   @Test(expected = MalformedExpressionException.class)
   public void testWrongOperator() throws MalformedExpressionException {
       PostfixEvaluator PostfixEvaluatorObj = new PostfixEvaluator("1 5 +");
       
//       try {
           double result = PostfixEvaluatorObj.eval();
//           fail();
//       } catch (MalformedExpressionException e) {
//
//       }
   }
}
