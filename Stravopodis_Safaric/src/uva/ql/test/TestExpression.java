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
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLParser;

public class TestExpression {
	
	private ASTNode returnExpr(String stream){
		ANTLRInputStream s = new ANTLRInputStream(stream);
		
		QLLexer lexer = new QLLexer(s);
		
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.expr();
		
		//Visitor visitor = new Visitor();
		//ASTNode ast = visitor.visit(tree);
		//return ast;
		return null;
	}
	
	@Test
	public void testMultiplicationEvaluation(){
		CodeLines codeLines = new CodeLines(1,1);
		Multiplication m = 
				new Multiplication(new Multiplication(new IntLiteral(3, codeLines), new IntLiteral(2, codeLines), codeLines), 
						new IntLiteral(1,codeLines), codeLines);
		
		assertEquals(m.evaluate().getValue(), 6);
	}
	@Test
	public void testAdditionEvaluation(){
		CodeLines codeLines = new CodeLines(1,1);
		Addition m = 
				new Addition(new Addition(new IntLiteral(3, codeLines), new IntLiteral(2, codeLines), codeLines), 
						new IntLiteral(1,codeLines), codeLines);
		
		assertEquals(m.evaluate().getValue(), 6);
	}
	@Test
	public void testSubstractionEvaluation(){
		CodeLines codeLines = new CodeLines(1,1);
		Substraction m = 
				new Substraction(new Substraction(new IntLiteral(3, codeLines), new IntLiteral(2, codeLines), codeLines), 
						new IntLiteral(1,codeLines), codeLines);
		assertEquals(m.evaluate().getValue(),0);
	}
	
}
