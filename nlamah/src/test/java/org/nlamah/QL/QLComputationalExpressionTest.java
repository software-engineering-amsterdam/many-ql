package org.nlamah.QL;

import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Binary.AddExpression;
import org.nlamah.QL.Model.Expression.Binary.DivideExpression;
import org.nlamah.QL.Model.Expression.Binary.MultiplyExpression;
import org.nlamah.QL.Model.Expression.Binary.SubtractExpression;
import org.nlamah.QL.Model.Expression.Evalutation.ExpressionEvaluator;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;

import junit.framework.TestCase;

public class QLComputationalExpressionTest extends TestCase 
{
	public void testNumberLiteral()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1");

		Expression referenceExpression = new NumberLiteral(1);

		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new NumberLiteral(1));
	}

	public void testAddition()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 + 2");

		Expression leftHandExpression = new NumberLiteral(1);
		Expression rightHandExpression = new NumberLiteral(2);

		Expression referenceExpression = new AddExpression(leftHandExpression, rightHandExpression);

		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new NumberLiteral(3));
	}

	public void testSubtraction()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("50 - 7");

		Expression leftHandExpression = new NumberLiteral(50);
		Expression rightHandExpression = new NumberLiteral(7);

		Expression referenceExpression = new SubtractExpression(leftHandExpression, rightHandExpression);

		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new NumberLiteral(43));
	}

	public void testMultiplication()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("20 *1000");

		Expression leftHandExpression = new NumberLiteral(20);
		Expression rightHandExpression = new NumberLiteral(1000);

		Expression referenceExpression = new MultiplyExpression(leftHandExpression, rightHandExpression);

		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new NumberLiteral(20000));
	}

	public void testDivision()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("7 / 9");

		Expression leftHandExpression = new NumberLiteral(7);
		Expression rightHandExpression = new NumberLiteral(9);

		Expression referenceExpression = new DivideExpression(leftHandExpression, rightHandExpression);

		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));

		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new NumberLiteral(1));
	}

	public void testSimpleParentheses()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("(1)");

		Expression referenceExpression = new NumberLiteral(1);

		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new NumberLiteral(1));
	}

	public void testComplexParenthese()
	{	
		Expression parsedExpression = QLTest.produceExpressionFromString("(1+2)/(3-4) + (50 * (13/13))");

		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(2);
		NumberLiteral numberLiteral3 = new NumberLiteral(3);
		NumberLiteral numberLiteral4 = new NumberLiteral(4);
		NumberLiteral numberLiteral5 = new NumberLiteral(50);
		NumberLiteral numberLiteral6 = new NumberLiteral(13);
		NumberLiteral numberLiteral7 = new NumberLiteral(13);

		Expression expression1 = new AddExpression(numberLiteral1, numberLiteral2);
		Expression expression2 = new SubtractExpression(numberLiteral3, numberLiteral4);
		Expression expression3 = new DivideExpression(expression1, expression2);

		Expression expression4 = new DivideExpression(numberLiteral6, numberLiteral7);
		Expression expression5 = new MultiplyExpression(numberLiteral5, expression4);

		Expression referenceExpression = new AddExpression(expression3, expression5);

		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new NumberLiteral(47));
	}
}