package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

public class TypeCheckerTest {
	@Rule
	public TestWatcher watcher = new TestWatcher() {
	   protected void starting(Description description) {
	      System.out.println("Starting test: " + description.getMethodName());
	   }
	};
	
	
	private TypeChecker typeChecker = new TypeChecker();
	
	@Test
	public void testFormVisitor() {
		String myForm = 
				"form taxOfficeExample {"
				+ 	"hasSoldHouse : boolean {"
				+ 		"\"Did you sell a house in 2010?\""
				+ 	"}"
				+ 	"if(5 == 5) {"
				+ 		"houseValue : money {"
				+ 			"\"Lol I dont care\""
				+ 		"}"
				+ 	"}"
				+ "}";
		
		ASTNode myTree = Parser.parse(myForm);
		
		typeChecker.checkStaticTypes(myTree);
	}
	
	@Test
	public void testExpressionVisitor() {
		String myExpression = "5 + 5";
		
		ASTNode myTree = Parser.parse(myExpression);

		typeChecker.checkStaticTypes(myTree);
	}
	
	@Test
	public void testTypeMismatch() {
		String myForm = "houseValue : money { \"Lol I dont care\" assign(\"Rubbish\") }";
		ASTNode result = Parser.parse(myForm);
		
		typeChecker.checkStaticTypes(result);
	}
	
	@Test
	public void testTypeArithmetic() {
		String myForm = "(59 + 295) / 1.1 * 194.235 - 104";
		ASTNode tree = Parser.parse(myForm);
		
		boolean result = typeChecker.checkStaticTypes(tree);
		System.out.println(result);
	}
	
	@Test
	public void testTypeOrAnd() {
		ASTNode tree = Parser.parse("(true && false) || false");		
		assertEquals(true, typeChecker.checkStaticTypes(tree));

		tree = Parser.parse("(true && false) || 123");		
		assertEquals(false, typeChecker.checkStaticTypes(tree));
		
		tree = Parser.parse("(true && lol) || 123");		
		assertEquals(false, typeChecker.checkStaticTypes(tree));
	}
	
	@Test
	public void testTypeIf() {
		ASTNode tree = Parser.parse("if (true) { houseValue : money { \"Lol I dont care\" } }");		
		assertEquals(true, typeChecker.checkStaticTypes(tree));

		tree = Parser.parse("if (false || true) { houseValue : money { \"Lol I dont care\" } }");		
		assertEquals(true, typeChecker.checkStaticTypes(tree));
		
		tree = Parser.parse("if (123) { houseValue : money { \"Lol I dont care\" } }");		
		assertEquals(false, typeChecker.checkStaticTypes(tree));
	}
}
