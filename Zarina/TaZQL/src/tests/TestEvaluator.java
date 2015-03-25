package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.expression.Expression;
import ast.expression.arithmetic.Addition;
import ast.expression.arithmetic.Division;
import ast.expression.arithmetic.Multiplication;
import ast.expression.arithmetic.Substraction;
import ast.expression.comparison.Equal;
import ast.expression.comparison.GreaterEqual;
import ast.expression.comparison.GreaterThan;
import ast.expression.comparison.LessEqual;
import ast.expression.comparison.LessThan;
import ast.expression.comparison.NotEqual;
import ast.expression.logical.And;
import ast.expression.logical.Or;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.IntegerVariable;
import ast.unary.Not;
import evaluator.EvaluatorVisitor;
import evaluator.Value;
import evaluator.ValueRepository;

public class TestEvaluator {

	private final IntegerVariable int4 = new IntegerVariable(4);
	
	private ValueRepository valrep = new ValueRepository();
	private EvaluatorVisitor eval;
	
	@Before 
	public void setUp() { 
		eval = new EvaluatorVisitor(valrep); 
	}
	
	public Value evaluate(Expression expression) {
		return expression.accept(this.eval);
	}
	
	@After
	public void tearDown() { eval = null; }

 
	@Test
	public void testAddition() {
		Value value = evaluate( new Addition(new IntegerVariable(3), new IntegerVariable(5)));
		Value value2 = evaluate( new Addition(new IntegerVariable(1), new IntegerVariable(4)));
		Value value3 = evaluate( new Addition(
				new Addition(new IntegerVariable(1), new IntegerVariable(4)), 
				int4));
		
		assertEquals("3+5 = 8", value.getValue(), 8);
		assertEquals("1+4 = 5", value2.getValue(), 5); 
		assertEquals("(1+4)+4 = 9", value3.getValue(), 9);
	}
	
	@Test
	public void testSubstraction() {
		Value value2 = evaluate( new Substraction(new IntegerVariable(75), new IntegerVariable(6)));
		Value value3 = evaluate( new Substraction(
				new Addition(new IntegerVariable(8), new IntegerVariable(6)), 
				int4));
		
		assertEquals("75-6=69", value2.getValue(), 69);
		assertEquals("(8+6)-4=10", value3.getValue(), 10);
	}
	
	@Test
	public void testMultiplication() {
		Value value = evaluate( new Multiplication(new IntegerVariable(5), new IntegerVariable(4)));
		
		assertEquals("5*4 = 20", value.getValue(), 20);
	}

	
	@Test
	public void testDivision() {
		Value value1 = evaluate(new Division(new IntegerVariable(200), new IntegerVariable(40)));
		Value value2 = evaluate(new Division(new IntegerVariable(45), new IntegerVariable(9)));
		
		assertEquals("200/40=5", value1.getValue(), 5);
		assertEquals("45/9=5", value2.getValue(), 5);
	}
	
	@Test
	public void testCalculations() {
		Value value1 = evaluate( new Multiplication(
				new Substraction(new IntegerVariable(7), new IntegerVariable(2)),
				new IntegerVariable(5)) );
		Value value2 = evaluate(new Multiplication(
				new Division(new IntegerVariable(48), new IntegerVariable(8)),
				new IntegerVariable(2)) );
				
		assertEquals("(7-2)*5=25", value1.getValue(), 25);
		assertEquals("(48/8)*2=12", value2.getValue(), 12);
	}
	
	
	@Test
	public void testAndComparisons() throws Exception {
		Value value1 = evaluate(new And(new BooleanVariable(true), new BooleanVariable(true)));
		Value value2 = evaluate(new And(new BooleanVariable(true), new BooleanVariable(false)));
		Value value3 = evaluate(new And(new BooleanVariable(false), new BooleanVariable(false)));
		
		assertEquals("t && t = t", value1.getValue(), true);
		assertEquals("t && f = f", value2.getValue(), false);
		assertEquals("f && f = f", value3.getValue(), false);
		
	}

	
	@Test
	public void testOrComparisons() throws Exception {
		Value value1 = evaluate(new Or(new BooleanVariable(true), new BooleanVariable(true)));
		Value value2 = evaluate(new Or(new BooleanVariable(true), new BooleanVariable(false)));
		Value value3 = evaluate(new Or(new BooleanVariable(false), new BooleanVariable(false)));
		
		assertEquals("t || t = t", value1.getValue(), true);
		assertEquals("t || f = t", value2.getValue(), true);
		assertEquals("f || f = f", value3.getValue(), false);
	}

	@Test
	public void testNotComparisons() throws Exception {
		Value value1 = evaluate(new Not(new BooleanVariable(true)));
		Value value2 = evaluate(new Not(new BooleanVariable(false)));
		
		assertEquals("!t = f", value1.getValue(), false);
		assertEquals("!f = t", value2.getValue(), true);
		
	}
	
	@Test
	public void testLogicalComparisons() throws Exception {
		Value value1 = evaluate(new Not(new Or(new BooleanVariable(true), new BooleanVariable(true))));
		Value value2 = evaluate(new Or(new BooleanVariable(true),
				new And( new BooleanVariable(false),new BooleanVariable(false))));
		
		assertEquals("!(t || t) = f", value1.getValue(), false);
		assertEquals("t || (f && f) = t", value2.getValue(), true);
	}
	
	@Test
	public void testComparisons() throws Exception {
		Value value1 = evaluate(new Equal(new IntegerVariable(7), new IntegerVariable(8)));
		Value value2 = evaluate(new GreaterEqual(new IntegerVariable(8), new IntegerVariable(8)));
		Value value3 = evaluate(new GreaterThan(new IntegerVariable(78), new IntegerVariable(8)));
		Value value4 = evaluate(new LessThan(new IntegerVariable(666), new IntegerVariable(-2)));
		Value value5 = evaluate(new LessEqual(new IntegerVariable(102), new IntegerVariable(103)));
		Value value6 = evaluate(new NotEqual(new IntegerVariable(102), new IntegerVariable(103)));
		
		assertEquals("7 ==8", value1.getValue(), false);
		assertEquals("8 >= 8", value2.getValue(), true);
		assertEquals("78 > 8", value3.getValue(), true);
		assertEquals("666 < -2", value4.getValue(), false);
		assertEquals("102 <= 103", value5.getValue(), true);
		assertEquals("102 != 103", value6.getValue(), true);
	}
	
	@Test
	public void testMix() throws Exception {
		Value value1 = evaluate(new Or(
				new Equal(new IntegerVariable(7), new IntegerVariable(8)), 
				new BooleanVariable(true))
		);
		Value value2 = evaluate(new And(
				new LessThan(new IntegerVariable(7), new IntegerVariable(8)), 
				new BooleanVariable(true))
		);
		
		assertEquals("(7 == 8) || true", value1.getValue(), true);
		assertEquals("(7 > 8 ) && true", value2.getValue(), true);
	}
	
}
