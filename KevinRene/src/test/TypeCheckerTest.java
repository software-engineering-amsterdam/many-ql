package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

public class TypeCheckerTest {
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
		
		myTree = typeChecker.checkStaticTypes(myTree);
	}
	
	@Test
	public void testExpressionVisitor() {
		String myExpression = "5 + 5";
		
		ASTNode myTree = Parser.parse(myExpression);

		myTree = typeChecker.checkStaticTypes(myTree);
	}
	
	@Test
	public void testTypeMismatch() {
		String myForm = "houseValue : money { \"Lol I dont care\" assign(\"Rubbish\") }";
		ASTNode result = Parser.parse(myForm);
		
		result = typeChecker.checkStaticTypes(result);
	}
}
