package uva.sc.ql.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uva.sc.ql.atom.*;
import uva.sc.ql.expression.Expression;
import uva.sc.ql.expression.binaryExpressions.*;
import uva.sc.ql.expression.unaryExpressions.*;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.helpers.QuestionData;

@SuppressWarnings({"rawtypes", "unchecked"})
public class EvaluatorVisitorTest {
    
    @Test
    public void id() {
	Map <ID, QuestionData> table = new HashMap<ID, QuestionData>();
	ID id = new ID("testQuestion");
	QuestionData data = new QuestionData(new NumberAtom(53.));
	table.put(id, data);
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(table);
	Expression expr = id;
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("Value of testQuestion stored in the table, expexted 53 but got " + result.getValue(), result.getValue() == 53);
    }
    
    @Test
    public void addition() {
	Expression expr = new Addition(new NumberAtom(24.), new NumberAtom(53.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("24 addited with 53, expected 77 but got " + result.getValue(), result.getValue() == 77);
    }

    public void substraction() {
	Expression expr = new Substraction(new NumberAtom(24.), new NumberAtom(53.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("24 substracted by 53, expected -29 but got " + result.getValue(), result.getValue() == -29);
    }
    
    @Test
    public void multiplication() {
	Expression expr = new Multiplication(new NumberAtom(24.), new NumberAtom(53.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("24 multiplied by 53, expected 1072 but got " + result.getValue(), result.getValue() == 1272);
    }
    
    @Test
    public void divisionByZero() {
	Expression expr = new Division(new NumberAtom(24.), new NumberAtom(0.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("24 divided 0, divide by zero should return Infinity but got " + result.getValue(), Double.isInfinite(result.getValue()));
    }
    
    @Test
    public void divideZeroByZero() {
	Expression expr = new Division(new NumberAtom(0.), new NumberAtom(0.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("0 divided by 0, divide by zero should return Infinity but got " + result.getValue(), Double.isNaN(result.getValue()));
    }
    
    @Test
    public void division() {
	Expression expr = new Division(new NumberAtom(24.), new NumberAtom(8.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("24 divided by 8, expected 3 but got " + result.getValue(), result.getValue() == 3);
    }
    
    @Test
    public void modulus() {
	Expression expr = new Modulus(new NumberAtom(26.), new NumberAtom(8.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("26 modulus 8, expexted 2 but got " + result.getValue(), result.getValue() == 2);
    }
    
    @Test
    public void modulusByZero() {
	Expression expr = new Modulus(new NumberAtom(26.), new NumberAtom(0.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("26 modulus 0, expexted isNaN but got " + result.getValue(), Double.isNaN(result.getValue()));
    }
    
    @Test
    public void and() {
	Expression expr = new And(new BooleanAtom(true), new BooleanAtom(false));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("true && false, expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void or() {
	Expression expr = new Or(new BooleanAtom(false), new BooleanAtom(true));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("false || true, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void equalsStringNonEquality() {
	Expression expr = new Equals(new StringAtom("EquallityTest"), new StringAtom("Test"));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("\"EquallityTest\" == \"Test\", expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void equalsString() {
	Expression expr = new Equals(new StringAtom("Test"), new StringAtom("Test"));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("\"Test\" == \"Test\", expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void equalsNumberNonEquality() {
	Expression expr = new Equals(new NumberAtom(10.), new NumberAtom(100.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("10 == 100, expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void equalsNumber() {
	Expression expr = new Equals(new NumberAtom(100.), new NumberAtom(100.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("100 == 100, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void equalsBooleanNonEquality() {
	Expression expr = new Equals(new BooleanAtom(true), new BooleanAtom(false));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("true == false, expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void equalsBoolean() {
	Expression expr = new Equals(new BooleanAtom(false), new BooleanAtom(false));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("false == false, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void notEqualsString() {
	Expression expr = new NotEquals(new StringAtom("EquallityTest"), new StringAtom("Test"));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("\"EquallityTest\" != \"Test\", expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void notEqualsStringEquality() {
	Expression expr = new NotEquals(new StringAtom("Test"), new StringAtom("Test"));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("\"Test\" != \"Test\", expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void notEqualsNumber() {
	Expression expr = new NotEquals(new NumberAtom(10.), new NumberAtom(100.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("10 != 100, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void notEqualsNumberEquality() {
	Expression expr = new NotEquals(new NumberAtom(100.), new NumberAtom(100.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("100 != 100, expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void notEqualsBoolean() {
	Expression expr = new NotEquals(new BooleanAtom(true), new BooleanAtom(false));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("true != false, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void notEqualsBooleanEquality() {
	Expression expr = new NotEquals(new BooleanAtom(true), new BooleanAtom(true));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("true != true, expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void greaterThanEquality() {
	Expression expr = new GreaterThan(new NumberAtom(10.), new NumberAtom(10.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("10 > 10, expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void notGreaterThan() {
	Expression expr = new GreaterThan(new NumberAtom(9.99), new NumberAtom(10.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("9.99 > 10, expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void greaterThanEqualsEquality() {
	Expression expr = new GreaterThanEquals(new NumberAtom(10.), new NumberAtom(10.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("10 >= 10, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void greaterThanEquals() {
	Expression expr = new GreaterThanEquals(new NumberAtom(10.01), new NumberAtom(10.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("10.01 >= 10, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void lesserThanEquality() {
	Expression expr = new LesserThan(new NumberAtom(10.), new NumberAtom(10.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("10 < 10, expected false but got " + result.getValue(), result.getValue() == false);
    }
    
    @Test
    public void lesserThan() {
	Expression expr = new LesserThan(new NumberAtom(9.99), new NumberAtom(10.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("9.99 < 10, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void lesserThanEqualsEquality() {
	Expression expr = new LesserThanEquals(new NumberAtom(10.), new NumberAtom(10.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("10 <= 10, expected true but got " + result.getValue(), result.getValue() == true);
    }
    
    @Test
    public void notLesserThanEquals() {
	Expression expr = new LesserThanEquals(new NumberAtom(10.01), new NumberAtom(10.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("10.01 <= 10, expected false but got " + result.getValue(), result.getValue() == false);
    }

    @Test 
    public void minus() {
	Expression expr = new Minus(new NumberAtom(-26.));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	NumberAtom result = (NumberAtom) expr.accept(evalVisitor);
	Assert.assertTrue("minus -26 , expexted 26 but got " + result.getValue(), result.getValue() == 26);
    }
    
    @Test 
    public void not() {
	Expression expr = new Not(new BooleanAtom(false));
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(null);
	BooleanAtom result = (BooleanAtom) expr.accept(evalVisitor);
	Assert.assertTrue("not false, expexted true but got " + result.getValue(), result.getValue());
    }
}
