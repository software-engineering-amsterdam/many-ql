package org.nlamah.QL;

import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Binary.AddExpression;
import org.nlamah.QL.Model.Expression.Binary.AndExpression;
import org.nlamah.QL.Model.Expression.Binary.EqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.GreaterThanExpression;
import org.nlamah.QL.Model.Expression.Binary.OrExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanEqualExpression;
import org.nlamah.QL.Model.Expression.Binary.SmallerThanExpression;
import org.nlamah.QL.Model.Expression.Binary.SubtractExpression;
import org.nlamah.QL.Model.Expression.Binary.UnEqualExpression;
import org.nlamah.QL.Model.Expression.Evalutation.ExpressionEvaluator;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;

import junit.framework.TestCase;

public class QLLogicalExpressionTest extends TestCase 
{
	public void testBoolenLiteral1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("yes");
		
		Expression referenceExpression = new BooleanLiteral(true);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testBoolenLiteral2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("no");
		
		Expression referenceExpression = new BooleanLiteral(false);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testAndOperation1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("yes && no");
		
		BooleanLiteral booleanLiteral1 = new BooleanLiteral(true);
		BooleanLiteral booleanLiteral2 = new BooleanLiteral(false);
		
		Expression referenceExpression = new AndExpression(booleanLiteral1, booleanLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));	
	}
	
	public void testAndOperation2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("yes && yes");
		
		BooleanLiteral booleanLiteral1 = new BooleanLiteral(true);
		BooleanLiteral booleanLiteral2 = new BooleanLiteral(true);
		
		Expression referenceExpression = new AndExpression(booleanLiteral1, booleanLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testAndOperation3()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("no && no");
		
		BooleanLiteral booleanLiteral1 = new BooleanLiteral(false);
		BooleanLiteral booleanLiteral2 = new BooleanLiteral(false);
		
		Expression referenceExpression = new AndExpression(booleanLiteral1, booleanLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testOrOperation1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("yes || no");
		
		BooleanLiteral booleanLiteral1 = new BooleanLiteral(true);
		BooleanLiteral booleanLiteral2 = new BooleanLiteral(false);
		
		Expression referenceExpression = new OrExpression(booleanLiteral1, booleanLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testOrOperation2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("no || no");
		
		BooleanLiteral booleanLiteral1 = new BooleanLiteral(false);
		BooleanLiteral booleanLiteral2 = new BooleanLiteral(false);
		
		Expression referenceExpression = new OrExpression(booleanLiteral1, booleanLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testOrOperation3()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("yes || yes");
		
		BooleanLiteral booleanLiteral1 = new BooleanLiteral(true);
		BooleanLiteral booleanLiteral2 = new BooleanLiteral(true);
		
		Expression referenceExpression = new OrExpression(booleanLiteral1, booleanLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testSmallerThanOperation1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 < 2");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(2);
		
		Expression referenceExpression = new SmallerThanExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testSmallerThanOperation2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("2 < 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(2);
		NumberLiteral numberLiteral2 = new NumberLiteral(1);
		
		Expression referenceExpression = new SmallerThanExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testSmallerThanEqualOperation1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 <= 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(1);
		
		Expression referenceExpression = new SmallerThanEqualExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testSmallerThanEqualOperation2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("2 <= 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(2);
		NumberLiteral numberLiteral2 = new NumberLiteral(1);
		
		Expression referenceExpression = new SmallerThanEqualExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testGreaterThanOperation1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("2 > 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(2);
		NumberLiteral numberLiteral2 = new NumberLiteral(1);
		
		Expression referenceExpression = new GreaterThanExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testGreaterThanOperation2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 > 2");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(2);
		
		Expression referenceExpression = new GreaterThanExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testGreaterThanOperation3()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1+2 > 3");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(2);
		NumberLiteral numberLiteral3 = new NumberLiteral(3);
		
		AddExpression addExpression = new AddExpression(numberLiteral1, numberLiteral2);
		
		Expression referenceExpression = new GreaterThanExpression(addExpression, numberLiteral3);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testGreaterThanEqualOperation1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 >= 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(1);
		
		Expression referenceExpression = new GreaterThanEqualExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testGreaterThanEqualOperation2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 >= 2");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(2);
		
		Expression referenceExpression = new GreaterThanEqualExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testEqualOperation1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 == 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(1);
		
		Expression referenceExpression = new EqualExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testEqualOperation2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 == 2");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(2);
		
		Expression referenceExpression = new EqualExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testEqualOperation3()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1+2 == 3");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(2);
		NumberLiteral numberLiteral3 = new NumberLiteral(3);
		
		AddExpression addExpression = new AddExpression(numberLiteral1, numberLiteral2);
		
		Expression referenceExpression = new EqualExpression(addExpression, numberLiteral3);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testEqualOperation4()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("3 == 1 + 2");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(3);
		NumberLiteral numberLiteral2 = new NumberLiteral(1);
		NumberLiteral numberLiteral3 = new NumberLiteral(2);
		
		AddExpression addExpression = new AddExpression(numberLiteral2, numberLiteral3);
		
		Expression referenceExpression = new EqualExpression(numberLiteral1, addExpression);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testEqualOperation5()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("\"hello\" == \"hello\"");
		
		TextLiteral textLiteral1 = new TextLiteral("hello");
		TextLiteral textLiteral2 = new TextLiteral("hello");
		
		Expression referenceExpression = new EqualExpression(textLiteral1, textLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testUnequalOperation1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 != 2");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(2);
		
		Expression referenceExpression = new UnEqualExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testUnequalOperation2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 != 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(1);
		
		Expression referenceExpression = new UnEqualExpression(numberLiteral1, numberLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
	
	public void testUnEqualOperation3()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("\"hello\" != \"world\"");
		
		TextLiteral textLiteral1 = new TextLiteral("hello");
		TextLiteral textLiteral2 = new TextLiteral("world");
		
		Expression referenceExpression = new UnEqualExpression(textLiteral1, textLiteral2);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testComplexLogicalExpression1()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 + 7 > 1 || 7 - 1 >= 1 - 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(7);
		NumberLiteral numberLiteral3 = new NumberLiteral(1);
		NumberLiteral numberLiteral4 = new NumberLiteral(7);
		NumberLiteral numberLiteral5 = new NumberLiteral(1);
		NumberLiteral numberLiteral6 = new NumberLiteral(1);
		NumberLiteral numberLiteral7 = new NumberLiteral(1);
		
		Expression addEpxression = new AddExpression(numberLiteral1, numberLiteral2);
		Expression greaterThanExpression = new GreaterThanExpression(addEpxression, numberLiteral3);
		
		Expression subtractExpression1 = new SubtractExpression(numberLiteral4,numberLiteral5);
		Expression subtractExpression2 = new SubtractExpression(numberLiteral6,numberLiteral7);
		
		Expression greaterThanEqualExpression = new GreaterThanEqualExpression(subtractExpression1, subtractExpression2);
		
		Expression referenceExpression = new OrExpression(greaterThanExpression, greaterThanEqualExpression);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(true));
	}
	
	public void testComplexLogicalExpression2()
	{
		Expression parsedExpression = QLTest.produceExpressionFromString("1 + 7 < 1 || 7 - 1 <= 1 - 1");
		
		NumberLiteral numberLiteral1 = new NumberLiteral(1);
		NumberLiteral numberLiteral2 = new NumberLiteral(7);
		NumberLiteral numberLiteral3 = new NumberLiteral(1);
		NumberLiteral numberLiteral4 = new NumberLiteral(7);
		NumberLiteral numberLiteral5 = new NumberLiteral(1);
		NumberLiteral numberLiteral6 = new NumberLiteral(1);
		NumberLiteral numberLiteral7 = new NumberLiteral(1);
		
		Expression addEpxression = new AddExpression(numberLiteral1, numberLiteral2);
		Expression smallerThanExpression = new SmallerThanExpression(addEpxression, numberLiteral3);
		
		Expression subtractExpression1 = new SubtractExpression(numberLiteral4,numberLiteral5);
		Expression subtractExpression2 = new SubtractExpression(numberLiteral6,numberLiteral7);
		
		Expression smallerThanEqualExpression = new SmallerThanEqualExpression(subtractExpression1, subtractExpression2);
		
		Expression referenceExpression = new OrExpression(smallerThanExpression, smallerThanEqualExpression);
		
		assertEquals(parsedExpression, referenceExpression);
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), referenceExpression.accept(new ExpressionEvaluator()));
		assertEquals(parsedExpression.accept(new ExpressionEvaluator()), new BooleanLiteral(false));
	}
}
