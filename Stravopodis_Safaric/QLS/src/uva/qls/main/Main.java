package uva.qls.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.qls.parser.*;
import uva.qls.ast.visitor.*;
import uva.qls.ast.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		ANTLRInputStream inputStream = new ANTLRInputStream(new FileInputStream("SupportingFiles/Style.qls"));
		QLSLexer lexer = new QLSLexer(inputStream);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		QLSParser parser = new QLSParser(stream);
		ParseTree tree = parser.prog();
		
		QLSMainVisitor visitor = new QLSMainVisitor();
		ASTNode ast = visitor.visit(tree);
		
		System.out.println(((Prog)ast).toString());
	}
	
}
