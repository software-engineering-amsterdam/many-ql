package tests.evaluator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.expression.arithmetic.AdditionExpression;
import ast.expression.arithmetic.DivisionExpression;
import ast.expression.arithmetic.MultiplicationExpression;
import ast.expression.arithmetic.SubstractionExpression;
import ast.expression.comparison.EqualExpression;
import ast.expression.comparison.GreaterEqualExpression;
import ast.expression.comparison.GreaterThanExpression;
import ast.expression.comparison.LessEqualExpression;
import ast.expression.comparison.LessThanExpression;
import ast.expression.comparison.NotEqualExpression;
import ast.expression.logical.AndExpression;
import ast.expression.logical.OrExpression;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.IntegerVariable;
import ast.unary.NotExpression;
import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.listeners.EvaluateExpression;

public class TestEvaluator {

	private final IntegerVariable int4 = new IntegerVariable(4);
	
	private ValueRepository valrep = new ValueRepository();
	private TestEvaluateExpression eval;
	
	@Before  // before each test
    public void setUp() { eval = new TestEvaluateExpression(valrep); }
	
	@After
	public void tearDown() { eval = null; }

 
	@Test
	public void testAddition() {
		Value value = eval.evaluate( new AdditionExpression(new IntegerVariable(3), new IntegerVariable(5)));
		Value value2 = eval.evaluate( new AdditionExpression(new IntegerVariable(1), new IntegerVariable(4)));
		Value value3 = eval.evaluate( new AdditionExpression(new AdditionExpression(new IntegerVariable(1), new IntegerVariable(4)), int4));
		
		assertEquals("3+5 = 8", value.getValue(), 8);
		assertEquals("1+4 = 5", value2.getValue(), 5); 
		assertEquals("(1+4)+4 = 9", value3.getValue(), 9);
	}
	
	@Test
	public void testSubstraction() {
		Value value2 = eval.evaluate( new SubstractionExpression(new IntegerVariable(75), new IntegerVariable(6)));
		Value value3 = eval.evaluate( new SubstractionExpression(new AdditionExpression(new IntegerVariable(8), new IntegerVariable(6)), int4));
		
		assertEquals("75-6=69", value2.getValue(), 69);
		assertEquals("(8+6)-4=10", value3.getValue(), 10);
	}
	
	@Test
	public void testMultiplication() {
		Value value = eval.evaluate( new MultiplicationExpression(new IntegerVariable(5), new IntegerVariable(4)));
		
		assertEquals("5*4 = 20", value.getValue(), 20);
	}

	
	@Test
	public void testDivision() {
		Value value1 = eval.evaluate(new DivisionExpression(new IntegerVariable(200), new IntegerVariable(40)));
		Value value2 = eval.evaluate(new DivisionExpression(new IntegerVariable(45), new IntegerVariable(9)));
		
		assertEquals("200/40=5", value1.getValue(), 5);
		assertEquals("45/9=5", value2.getValue(), 5);
	}
	
	@Test
	public void testCalculations() {
		Value value1 = eval.evaluate( new MultiplicationExpression(
											new SubstractionExpression(new IntegerVariable(7), new IntegerVariable(2)),  
											new IntegerVariable(5)) );
		Value value2 = eval.evaluate(new MultiplicationExpression(
											new DivisionExpression(new IntegerVariable(48), new IntegerVariable(8)),
											new IntegerVariable(2)) );
				
		assertEquals("(7-2)*5=25", value1.getValue(), 25);
		assertEquals("(48/8)*2=12", value2.getValue(), 12);
	}
	
	
	@Test
	public void testAndComparissions() throws Exception {
		Value value1 = eval.evaluate(new AndExpression(new BooleanVariable(true), new BooleanVariable(true)));
		Value value2 = eval.evaluate(new AndExpression(new BooleanVariable(true), new BooleanVariable(false)));
		Value value3 = eval.evaluate(new AndExpression(new BooleanVariable(false), new BooleanVariable(false)));
		
		assertEquals("t && t = t", value1.getValue(), true);
		assertEquals("t && f = f", value2.getValue(), false);
		assertEquals("f && f = f", value3.getValue(), false);
		
	}

	
	@Test
	public void testOrComparissions() throws Exception {
		Value value1 = eval.evaluate(new OrExpression(new BooleanVariable(true), new BooleanVariable(true)));
		Value value2 = eval.evaluate(new OrExpression(new BooleanVariable(true), new BooleanVariable(false)));
		Value value3 = eval.evaluate(new OrExpression(new BooleanVariable(false), new BooleanVariable(false)));
		
		assertEquals("t || t = t", value1.getValue(), true);
		assertEquals("t || f = t", value2.getValue(), true);
		assertEquals("f || f = f", value3.getValue(), false);
	}

	@Test
	public void testNotComparissions() throws Exception {
		Value value1 = eval.evaluate(new NotExpression(new BooleanVariable(true)));
		Value value2 = eval.evaluate(new NotExpression(new BooleanVariable(false)));
		
		assertEquals("!t = f", value1.getValue(), false);
		assertEquals("!f = t", value2.getValue(), true);
		
	}
	
	@Test
	public void testLogicalComparissions() throws Exception {
		Value value1 = eval.evaluate(new NotExpression(new OrExpression(new BooleanVariable(true), new BooleanVariable(true))));
		Value value2 = eval.evaluate(new OrExpression(new BooleanVariable(true), 
													  new AndExpression( new BooleanVariable(false),new BooleanVariable(false))));
		
		assertEquals("!(t || t) = f", value1.getValue(), false);
		assertEquals("t || (f && f) = t", value2.getValue(), true);
	}
	
	@Test
	public void testComparissions() throws Exception {
		Value value1 = eval.evaluate(new EqualExpression(new IntegerVariable(7), new IntegerVariable(8)));
		Value value2 = eval.evaluate(new GreaterEqualExpression(new IntegerVariable(8), new IntegerVariable(8)));
		Value value3 = eval.evaluate(new GreaterThanExpression(new IntegerVariable(78), new IntegerVariable(8)));
		Value value4 = eval.evaluate(new LessThanExpression(new IntegerVariable(666), new IntegerVariable(-2)));
		Value value5 = eval.evaluate(new LessEqualExpression(new IntegerVariable(102), new IntegerVariable(103)));
		Value value6 = eval.evaluate(new NotEqualExpression(new IntegerVariable(102), new IntegerVariable(103)));
		
		assertEquals("7 ==8", value1.getValue(), false);
		assertEquals("8 >= 8", value2.getValue(), true);
		assertEquals("78 > 8", value3.getValue(), true);
		assertEquals("666 < -2", value4.getValue(), false);
		assertEquals("102 <= 103", value5.getValue(), true);
		assertEquals("102 != 103", value6.getValue(), true);
	}
	
	@Test
	public void testMix() throws Exception {
		Value value1 = eval.evaluate(new OrExpression(new EqualExpression(new IntegerVariable(7), new IntegerVariable(8)), new BooleanVariable(true)));
		Value value2 = eval.evaluate(new AndExpression(new LessThanExpression(new IntegerVariable(7), new IntegerVariable(8)), new BooleanVariable(true)));
		
		assertEquals("(7 == 8) || true", value1.getValue(), true);
		assertEquals("(7 > 8 ) && true", value2.getValue(), true);
	}
	
}
