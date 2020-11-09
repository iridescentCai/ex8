package postfix;

import java.util.Stack;
import parser.Token;
import parser.Scanner;
import parser.MalformedExpressionException;

/**
 *
 * @author Sathish Gopalakrishnan
 *
 * This class contains a method to evaluate an arithmetic expression
 * that is in Postfix notation (or Reverse Polish Notation).
 * See <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Wikipedia</a>
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
     * <strong>in Postfix notation</strong>.
     */
    public PostfixEvaluator( String expr ) {
        arithmeticExpr = expr;
    }

    /**
     * This method evaluates the arithmetic expression that
     * was passed as a string to the constructor for this class.
     *
     * @return the value of the arithmetic expression
     * @throws MalformedExpressionException if the provided expression is not
     * 	a valid expression in Postfix notation
     */
    double eval( ) throws MalformedExpressionException {
        Stack<Token> stack;
        // TODO: Implement this method.
        // The code provided here is for illustration only, and
        // can be deleted when you write your implementation.

        // Using a stack makes it very simple to evaluate the
        // arithmetic expression.
        // See http://docs.oracle.com/javase/8/docs/api/java/util/Stack.html

        // Use the Scanner to get the elements (tokens) in the
        // arithmetic expression.

        Scanner scanner = new Scanner(arithmeticExpr);
        stack = new Stack<>();

        while (!scanner.isEmpty()) {
            Token currToken = scanner.getToken();
            // System.out.println(currToken);

            if (!currToken.isDouble()) { // If the judgment is an operator, two operasties are stacked

                if (! (stack.size() >= 2)) {
                    throw new MalformedExpressionException("The expression is wrong");
                }

                double op2 = (stack.pop()).getValue();

                double op1 = (stack.pop()).getValue();

                String operator = currToken.getName(); // Extract the operator



                stack.add(calc(operator, op1, op2)); // Press the results into the stack

            } else {

                //stack.push(Double.parseDouble(currToken)); // Press in the operating number
                stack.add(currToken);

            }
                scanner.eatToken();
            }

            if (stack.size() == 1) {
                Token t = stack.pop();
                if (t.isDouble()) {
                    return t.getValue();
                }
            }
            throw new MalformedExpressionException("Incorrect expression");

        }


        /*
         * @param operation Operator
         * @param op1 The number of operations 1
         * @param op2 The number of operations 2
         * @return The result of the calculation
         */
        private static Token calc(String operation, double op1, double op2) {

            Double tatol = 0.0;

            switch (operation) {
                case "+":
                    tatol = op1 + op2;
                    break;
                case "-":
                    tatol = op1 - op2;
                    break;
                case "*":
                    tatol = op1 * op2;
                    break;
                case "/":
                    tatol = op1 / op2;

                    break;

            }

            return new Token(tatol);

        }

}