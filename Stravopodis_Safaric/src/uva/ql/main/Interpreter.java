package uva.ql.main;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.math.*;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLParser;
import uva.ql.parser.Visitor;
import uva.ql.supporting.Tuple;


public class Interpreter{
	
	public static void main(String[] args) throws IOException{
		
		
		
		ANTLRInputStream inputStream = new ANTLRInputStream(new FileInputStream("SupportingFiles/Test.ql"));
		
		QLLexer lexer = new QLLexer(inputStream);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		
		QLParser parser = new QLParser(stream);
		//parser.setBuildParseTree(true);
		
		//Visitor visitor = new Visitor();
		
        ParseTree tree = parser.prog();
		
		Visitor myVisit = new Visitor();
		
		myVisit.visit(tree);
		
		
		
	}
	
	
}
