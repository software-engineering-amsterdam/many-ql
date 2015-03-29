package uva.ql.test;

import static org.junit.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import uva.ql.ast.Node;
import uva.ql.ast.Prog;
import uva.ql.ast.expression.evaluation.ValueTable;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;


public class TestExpressionEvaluator {

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
	
	@Test
	public void testExpressionEvaluator_ValueTable(){
		ParseTree tree = this.getParseTree("src/uva/ql/test/source/Evaluator.ql");
		Prog prog = (Prog)this.getAbstractSyntaxTree(tree);
		
		ValueTable table = new ValueTable(prog);
		int a = (int)table.getValue("a").getValue();
		int b = (int)table.getValue("b").getValue();
		int c = (int)table.getValue("c").getValue();
		
		assertEquals(a, 0);
		assertEquals(b, 2);
		assertEquals(c, 2);
	}

}
