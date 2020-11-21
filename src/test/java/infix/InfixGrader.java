package infix;

import static org.junit.Assert.*;

import org.junit.Test;
import java.math.BigDecimal;

public class InfixGrader {

	@Test
	public void test1() {
		String expr = "((1 + 2) + 3)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(myTree.eval(), new BigDecimal(6.0));
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
		
	}

	@Test
	public void test2() {
		String expr = "((1 + 2) * 3)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(myTree.eval(), new BigDecimal(9.0));
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
		
	}
	
	@Test
	public void test3() {
		String expr = "((1 + 2) / 3)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(1), myTree.eval());
		}
		catch( Exception e ) {
			fail();
		}
		
	}

	@Test
	public void test4() {
		String expr = "(2 * 2)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(4.0), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test5() {
		String expr = "(-2 / 2)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(myTree.eval(), new BigDecimal(-1.0));
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test6() {
		String expr = "(4 / 1)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(4), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test7() {
		String expr = "(-1 / 2)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(-0.5), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test8() {
		String expr = "(5 / 2)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(2.5), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test9() {
		String expr = "(5000000/ 2000000)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(2.5), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test10() {
		String expr = "(-5000000/ 2000000)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(-2.5), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test11() {
		String expr = "((3 * (-5000000/ 2000000)) / 3)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(-2.5), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test12() {
		String expr = "(-60000000 / -30000000)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(2), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test(expected = ArithmeticException.class)
	public void test16() {
		String expr = "( ((843 * (-40000000 / -30004567)) - 959) / 0)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			myTree.eval();
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test(expected = ArithmeticException.class)
	public void test17() {
		String expr = "(0 / 0)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			myTree.eval();
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test(expected = ArithmeticException.class)
	public void test18() {
		String expr = "(0 / (5 * 0)))";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			myTree.eval();
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test19() {
		String expr = "(1 + (2 - (7 * (9 / 3))))";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(1 + 2 - 7 * (9/3)), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test20() {
		String expr = "(17 / 16)";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			boolean possibility1 = (new BigDecimal(1)).equals(myTree.eval());
			boolean possibility2 = (new BigDecimal(1.0625)).equals(myTree.eval());
			boolean possibility3 = (new BigDecimal(1.06)).equals(myTree.eval());
			
			assertEquals(true, possibility1 || possibility2 || possibility3);
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test22() {
		String expr = "(22 * (23 * 67))";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(22 * 23 * 67), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}

	@Test
	public void test23() {
		String expr = "(23 * (67 / 67))";
		ArithmeticExpressionTree myTree;
		try {
			myTree = new ArithmeticExpressionTree(expr);
			assertEquals(new BigDecimal(23), myTree.eval());
		}
		catch( MalformedExpressionException e ) {
			fail("Exception!");
		}
	}


}