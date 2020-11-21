package postfix;

import static org.junit.Assert.*;

import org.junit.Test;
import parser.MalformedExpressionException;

public class PostfixGrader {

	@Test
	public void test1() throws MalformedExpressionException {
	    assertEquals(7, new PostfixEvaluator("5 2 +").eval(), 0);
	}

    @Test
    public void test2() throws MalformedExpressionException {
        assertEquals(8, new PostfixEvaluator("5 2 + 7 - 8 +").eval(), 0);
    }

    @Test
    public void test3() throws MalformedExpressionException {
        assertEquals(-40, new PostfixEvaluator("5 2 + 7 - 8 + 0 5 - *").eval(), 0);
    }

    @Test(expected = MalformedExpressionException.class)
    public void test4() throws MalformedExpressionException {
        assertEquals(-40, new PostfixEvaluator("5 2 + 7 - 8 + 0 5 - * +").eval(), 0);
    }

    @Test(expected = MalformedExpressionException.class)
    public void test5() throws MalformedExpressionException {
        new PostfixEvaluator("+").eval();
    }

    @Test
    public void test6() throws MalformedExpressionException {
        assertEquals(
            -8.79269181152,
            new PostfixEvaluator("5 9 2 / + 13 - 228.34 323 / + 9 - 1 2 + + 2 233 / 23 / +").eval(),
            0.0000000001
        );
    }

    @Test
    public void test7() throws MalformedExpressionException {
        assertEquals(0, new PostfixEvaluator("1 0 *").eval(), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void test8() throws MalformedExpressionException {
        new PostfixEvaluator("5 0 /").eval();
    }

    @Test
    public void test9() throws MalformedExpressionException {
        assertEquals(
            -14916.367564,
            new PostfixEvaluator("0 5 * 10 76 * 51 / 0.000001 * 1000000000 * - 13 17 15.34 / * -").eval(),
            0.0000001
        );
    }

    @Test(expected = MalformedExpressionException.class)
    public void test10() throws MalformedExpressionException {
        new PostfixEvaluator("0 5 * 10 76 * 51 / 0.000001 1000000000 * - 13 17 15.34 / * -").eval();
    }

    @Test(expected = ArithmeticException.class)
    public void test11() throws MalformedExpressionException {
        new PostfixEvaluator("0 5 * 10 76 * 51 / 0.000001 * 1000000000 * - 13 17 15.34 / * - 0 /").eval();
    }

}
