package uva.ql.test;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import uva.ql.ast.Node;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.value.BooleanValue;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;

public class TestExpression {
	
	private Node returnExpr(String stream){
		ANTLRInputStream s = new ANTLRInputStream(stream);
		
		QLLexer lexer = new QLLexer(s);
		
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.expr();
		
		QLMainVisitor visitor = new QLMainVisitor();
		Node ast = visitor.visit(tree);
		return ast;
	}
	
	@Test
	public void testMultiplication(){
		Expression expression = (Expression)this.returnExpr("2*3*4");
		assertEquals(expression.evaluate().getValue(), 24);
	}
	@Test
	public void testAddition(){
		Expression expression = (Expression)this.returnExpr("2+5+4+6+3");
		assertEquals(expression.evaluate().getValue(), 20);
	}
	@Test
	public void testSubstraction(){
		Expression expression = (Expression)this.returnExpr("20-2-5-3");
		assertEquals(expression.evaluate().getValue(),10);
	}
	@Test
	public void testDivision(){
		Expression expression = (Expression)this.returnExpr("200/2/4");
		assertEquals(expression.evaluate().getValue(),25);
	}
	@Test
	public void testExponentiation(){
		Expression expression = (Expression)this.returnExpr("2^2");
		assertEquals(expression.evaluate().getValue(),4);
	}
	@Test
	public void testGreater(){
		Expression expression = (Expression)this.returnExpr("2>3");
		assertEquals(expression.evaluate().getValue(),false);
	}
	@Test
	public void testLess(){
		Expression expression = (Expression)this.returnExpr("8<10");
		assertEquals(expression.evaluate().getValue(),true);
	}
	@Test
	public void testLessEqual(){
		Expression expression = (Expression)this.returnExpr("8<=8");
		Expression expression2 = (Expression)this.returnExpr("8<=10");
		
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),true);
	}
	
	@Test
	public void testGreaterEqual(){
		Expression expression = (Expression)this.returnExpr("10>=8");
		Expression expression2 = (Expression)this.returnExpr("8>=10");
		
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),false);
	}
	@Test
	public void testEqual(){
		Expression expression = (Expression)this.returnExpr("8==8");
		Expression expression2 = (Expression)this.returnExpr("true==true");
		
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),true);
	}
	@Test
	public void testNotEqual(){
		Expression expression = (Expression)this.returnExpr("true!=true");
		Expression expression2 = (Expression)this.returnExpr("true!=false");
		
		assertEquals(expression.evaluate().getValue(),false);
		assertEquals(expression2.evaluate().getValue(),true);
	}
	@Test
	public void testAnd(){
		Expression expression = (Expression)this.returnExpr("true && true");
		Expression expression2 = (Expression)this.returnExpr("true && false");
		
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),false);
	}
	
	@Test
	public void testOr(){
		Expression expression = (Expression)this.returnExpr("true || false");
		Expression expression2 = (Expression)this.returnExpr("false || false");
		
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),false);
	}
	
	@Test
	public void testRandomExpressions(){
		Expression expression = (Expression)this.returnExpr("(20+3-8)*10");
		Expression expression2 = (Expression)this.returnExpr("((30+8+12)*12/2) <= 300 ");
		Expression expression3 = (Expression)this.returnExpr("((30+8+12)*12/2) > 300 ");
		
		assertEquals(expression.evaluate().getValue(),150);
		assertEquals(expression2.evaluate().getValue(),true);
		assertEquals(expression3.evaluate().getValue(),false);
	}
	
	@Test
	public void testType(){
		BooleanValue bool = new BooleanValue(true);
		assertEquals(bool.getValue(),true);
	}
}