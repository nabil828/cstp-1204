import java.util.Stack;

public class MyMain {
    public static void main(String[] args){
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("enter an integer");
        String myString = keyboard.nextLine();
        
        PostfixEvaluator PostfixEvaluatorObj = new PostfixEvaluator(myString);
        try {
            System.out.println("The result is " + Double.toString(PostfixEvaluatorObj.eval()));
        } catch (MalformedExpressionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}
