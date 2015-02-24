package uva.TaxForm;

import java.net.URL;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.TaxForm.AST.Nodes.NodeForm;
import uva.TaxForm.AST.Visitors.CommonTaxFormVisitor;
import uva.TaxForm.AST.Visitors.Checker.QuestionChecker;
import uva.TaxForm.antlr4.TaxFormLexer;
import uva.TaxForm.antlr4.TaxFormParser;

public class TaxForm {
	private URL formDefinition;
	private String filePath;
	
    public TaxForm(URL url, boolean internal) {
    	formDefinition = url;
    	
    	if (internal) {
	    	filePath = formDefinition.getPath().toString().substring(1, formDefinition.getPath().toString().length());
    	} else {
	    	filePath = formDefinition.getPath().toString();
    	}
    	
    	System.out.println( "filePath: " + filePath );
    }
    
    public void start() throws Exception {
    	
    	ANTLRFileStream input = new ANTLRFileStream(filePath, "UTF-8");
    	
    	TaxFormLexer lexer = new TaxFormLexer(input);
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
		TaxFormParser parser = new TaxFormParser(tokens);
		
		ParseTree tree = parser.form();
		CommonTaxFormVisitor visitor = new CommonTaxFormVisitor();
		NodeForm ast = (NodeForm) visitor.visit(tree);
		
		System.out.println( ast.getName() );
		
		QuestionChecker Qchecker = new QuestionChecker();
		System.out.println( Qchecker.duplicates(ast) );
    }
}
