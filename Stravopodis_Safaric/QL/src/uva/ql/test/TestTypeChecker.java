package uva.ql.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import uva.ql.ast.Node;
import uva.ql.ast.Prog;
import uva.ql.interpreter.typecheck.TypeCheckVisitor;
import uva.ql.interpreter.typecheck.error.IssueObject;
import uva.ql.interpreter.typecheck.error.IssueType;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;

public class TestTypeChecker {

	private ParseTree getParseTree(String fromPath){
		ANTLRInputStream inputStream = null;
		
		try{
			inputStream = new ANTLRInputStream(new FileInputStream(fromPath));
		}
		catch (IOException e){
			System.out.println("Exception: " + e.getMessage());
		}
		
		QLLexer lexer = new QLLexer(inputStream);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(stream);
		ParseTree tree = parser.prog();
		
		return tree;
	}
	
	private Node getAbstractSyntaxTree(ParseTree fromTree){
		QLMainVisitor visitor = new QLMainVisitor();
		Node ast = visitor.visit(fromTree);
		
		return ast;
	}
	
	private TypeCheckVisitor getTypeCheck(String forPath){
		ParseTree tree = this.getParseTree(forPath);
		Prog prog = (Prog)this.getAbstractSyntaxTree(tree);
		TypeCheckVisitor typeCheck = new TypeCheckVisitor();
		typeCheck.visitProg(prog);
		
		return typeCheck;
	}
	
	/* Type Check Tests */
	
	@Test
	public void testDuplicateSameType(){
		TypeCheckVisitor typeCheck = this.getTypeCheck("src/uva/ql/test/source/Duplicate.ql");
		List<IssueObject> issues = typeCheck.getErrorOfType(IssueType.ERROR.DUPLICATE_SAME_TYPE);
		
		assertEquals(issues.size(), 1);
	}
	
	@Test
	public void testDuplicateDifferentType(){
		TypeCheckVisitor typeCheck = this.getTypeCheck("src/uva/ql/test/source/Duplicate.ql");
		List<IssueObject> issues = typeCheck.getErrorOfType(IssueType.ERROR.DUPLICATE_DIFFERENT_TYPE);
		
		assertEquals(issues.size(), 1);
	}
	
	@Test
	public void testBooleanCondition(){
		TypeCheckVisitor typeCheck = this.getTypeCheck("src/uva/ql/test/source/Condition.ql");
		List<IssueObject> issues = typeCheck.getErrorOfType(IssueType.ERROR.CONDITION_NOT_BOOLEAN);
		
		assertEquals(issues.size(), 1);
	}
	
	@Test
	public void testInvalidOperandsMath(){
		TypeCheckVisitor typeCheck = this.getTypeCheck("src/uva/ql/test/source/InvalidOperator.ql");
		List<IssueObject> issues = typeCheck.getErrorOfType(IssueType.ERROR.INVALID_OPERANDS_MATH);
		
		assertEquals(issues.size(), 1);
	}
	
	@Test
	public void testInvalidOperandsLogic(){
		TypeCheckVisitor typeCheck = this.getTypeCheck("src/uva/ql/test/source/InvalidOperator.ql");
		List<IssueObject> issues = typeCheck.getErrorOfType(IssueType.ERROR.INVALID_OPERANDS_LOGICAL);
		
		assertEquals(issues.size(), 1);
	}
	
	@Test
	public void testCyclicDependency(){
		TypeCheckVisitor typeCheck = this.getTypeCheck("src/uva/ql/test/source/CyclicDependency.ql");
		List<IssueObject> issues = typeCheck.getErrorOfType(IssueType.ERROR.CYCLIC_DEPENDANCIES);
		
		assertEquals(issues.size(), 2);
	}

}
