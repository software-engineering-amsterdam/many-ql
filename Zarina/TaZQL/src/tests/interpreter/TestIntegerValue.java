package tests.interpreter;

import static org.junit.Assert.assertEquals;
import interpreter.EvaluatorVisitor;
import interpreter.IntegerValue;
import interpreter.ValueRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.expression.arithmetic.AdditionExpression;
import ast.expression.arithmetic.DivisionExpression;
import ast.expression.arithmetic.MultiplicationExpression;
import ast.expression.arithmetic.SubstractionExpression;
import ast.expression.logical.OrExpression;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.IntegerVariable;

public class TestIntegerValue {

	private final IntegerVariable int1 = new IntegerVariable(1);
	private final IntegerVariable int4 = new IntegerVariable(4);
	private final IntegerValue int5 = new IntegerValue(5);
	private final IntegerValue int9 = new IntegerValue(9);
	private final IntegerValue int20 = new IntegerValue(20);
	
	//private BooleanVariable b_true = new BooleanVariable(true);
	//private BooleanVariable b_false = new BooleanVariable(false);
	
	ValueRepository valrep = new ValueRepository();
	EvaluatorVisitor vis;
	
	@Before  // before each test
    public void setUp() { vis = new EvaluatorVisitor(valrep); }
	
	@After
	public void tearDown() { vis = null; }

 
	@Test
	public void testAddition() {
		assertEquals("1+4 = 5", vis.testExpression(new AdditionExpression(int1, int4)), int5); 
		assertEquals("(1+4)+4 = 9", vis.testExpression(new AdditionExpression(new AdditionExpression(int1, int4), int4)), int9);
	}
	
	@Test
	public void testSubstraction() {
		assertEquals("13-7=6", vis.testExpression(new SubstractionExpression(
													new IntegerVariable(13), new IntegerVariable(7))), 
							   6);
	}
	
	@Test
	public void testMultiplication() {
		assertEquals("5*4=20", vis.testExpression(new MultiplicationExpression(
													new IntegerVariable(5), new IntegerVariable(4))), 
							   int20);
	}
	
	@Test
	public void testDivision() {
		assertEquals("200/40=50", vis.testExpression(new DivisionExpression(
													new IntegerVariable(200), new IntegerVariable(40))), 
								50);
	}
	
	@Test
	public void testCalculations() {
		assertEquals("(7-2)*5=25", vis.testExpression(new MultiplicationExpression(
													  new SubstractionExpression(new IntegerVariable(7), new IntegerVariable(2)),
													  new IntegerVariable(5))), 
							   new IntegerValue(25));
		assertEquals("(48/8)*2=12", vis.testExpression(new MultiplicationExpression(
													 new DivisionExpression(new IntegerVariable(48), new IntegerVariable(8)),
													 new IntegerVariable(2))), 
								new IntegerValue(12));
	}
	
	@Test
	public void testComparissions() throws Exception {
		assertEquals("T || T", vis.testExpression(new OrExpression(new BooleanVariable(true), new BooleanVariable(true))), new BooleanVariable(true));
	}


}
