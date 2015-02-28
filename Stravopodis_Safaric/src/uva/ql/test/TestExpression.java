package uva.ql.test;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.IntLiteral;
import uva.ql.ast.expressions.math.Addition;
import uva.ql.ast.expressions.math.Division;
import uva.ql.ast.expressions.math.Multiplication;
import uva.ql.ast.expressions.math.Substraction;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.Visitor;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;

public class TestExpression {
	
	private ASTNode returnExpr(String stream){
		ANTLRInputStream s = new ANTLRInputStream(stream);
		
		QLLexer lexer = new QLLexer(s);
		
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.expr();
		
		QLMainVisitor visitor = new QLMainVisitor();
		ASTNode ast = visitor.visit(tree);
		return ast;
	}
	
	@Test
	public void testMultiplicationEvaluation(){
		Expression expression = (Expression)this.returnExpr("2*3*4");
		assertEquals(expression.evaluate().getValue(), (float)24);
	}
	@Test
	public void testAdditionEvaluation(){
		Expression expression = (Expression)this.returnExpr("2+5+4+6+3");
		assertEquals(expression.evaluate().getValue(), (float)20);
	}
	@Test
	public void testSubstractionEvaluation(){
		Expression expression = (Expression)this.returnExpr("20-2-5-3");
		assertEquals(expression.evaluate().getValue(),(float)10);
	}
	@Test
	public void testDivisionEvaluation(){
		Expression expression = (Expression)this.returnExpr("200/2/4");
		assertEquals(expression.evaluate().getValue(),(float)25);
	}
	@Test
	public void testExponentiationEvaluation(){
		Expression expression = (Expression)this.returnExpr("2^2");
		assertEquals(expression.evaluate().getValue(),(float)4);
	}
	@Test
	public void testGreatEvaluation(){
		Expression expression = (Expression)this.returnExpr("2>3");
		assertEquals(expression.evaluate().getValue(),false);
	}
	@Test
	public void testLessEvaluation(){
		Expression expression = (Expression)this.returnExpr("8<10");
		assertEquals(expression.evaluate().getValue(),true);
	}
	@Test
	public void testLessEQEvaluation(){
		Expression expression = (Expression)this.returnExpr("8<=8");
		Expression expression2 = (Expression)this.returnExpr("8<=10");
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),true);
	}
	
	@Test
	public void testGreatEQEvaluation(){
		Expression expression = (Expression)this.returnExpr("10>=8");
		Expression expression2 = (Expression)this.returnExpr("8>=10");
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),false);
	}
	@Test
	public void testEqualEvaluation(){
		Expression expression = (Expression)this.returnExpr("8==8");
		Expression expression2 = (Expression)this.returnExpr("true==true");
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),true);
	}
	@Test
	public void testNotEqualEvaluation(){
		Expression expression = (Expression)this.returnExpr("true!=true");
		Expression expression2 = (Expression)this.returnExpr("true!=false");
		assertEquals(expression.evaluate().getValue(),false);
		assertEquals(expression2.evaluate().getValue(),true);
	}
	@Test
	public void testAndEvaluation(){
		Expression expression = (Expression)this.returnExpr("true && true");
		Expression expression2 = (Expression)this.returnExpr("true && false");
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),false);
	}
	
	@Test
	public void testOrEvaluation(){
		Expression expression = (Expression)this.returnExpr("true || false");
		Expression expression2 = (Expression)this.returnExpr("false || false");
		assertEquals(expression.evaluate().getValue(),true);
		assertEquals(expression2.evaluate().getValue(),false);
		}
	
	@Test
	public void testRandomEvaluation(){
		Expression expression = (Expression)this.returnExpr("(20+3-8)*10");
		Expression expression2 = (Expression)this.returnExpr("((30+8+12)*12/2) <= 300 ");
		Expression expression3 = (Expression)this.returnExpr("((30+8+12)*12/2) > 300 ");
		System.out.println(expression2.evaluate().getValue());
		assertEquals(expression.evaluate().getValue(),(float)150);
		assertEquals(expression2.evaluate().getValue(),true);
		assertEquals(expression3.evaluate().getValue(),false);
	}
	
	@Test
	public void testTypeEvaluation(){
		BooleanValue bool = new BooleanValue(true);
		assertEquals(bool.getValue(),true);
	}
}
/* old way
CodeLines codeLines = new CodeLines(1,1);
Addition m = 
		new Addition(new Addition(new IntLiteral(3, codeLines), new IntLiteral(2, codeLines), codeLines), 
				new IntLiteral(1,codeLines), codeLines);
*/