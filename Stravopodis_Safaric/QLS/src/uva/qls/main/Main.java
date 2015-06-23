package uva.qls.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

//import uva.qls.interpreter.gui.GUI;
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
		ASTNode _ast = visitor.visit(tree);
		System.out.println(_ast);
		
		//GUI gui = new GUI(_ast);
		
		//for (String key : gui.getTypeCheck().getErrorTable().getTable().keySet()){
			//System.err.println(key + " ===== " + gui.getTypeCheck().getErrorTable().retrieveValue(key));
		//}
		
		//if (gui.getTypeCheck().hasErrors())
			//System.out.println("Will not generate, has errors");
	}
	
}
