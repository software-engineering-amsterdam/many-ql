package uva.TaxForm;

import java.net.URL;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import uva.TaxForm.antlr4.TaxFormLexer;
import uva.TaxForm.antlr4.TaxFormParser;

public class TaxForm {
	private URL formDefinition;
	private String filePath;
	
    public TaxForm(URL url) {
    	formDefinition = url;
    	filePath = formDefinition.getPath().toString().substring(1, formDefinition.getPath().toString().length());
    	System.out.println( filePath );
    }
    
    public void start() throws Exception {
    	
    	ANTLRFileStream input = new ANTLRFileStream(filePath, "UTF-8");
    	
    	TaxFormLexer lexer = new TaxFormLexer(input);
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
		TaxFormParser parser = new TaxFormParser(tokens);
		
		ParseTreeWalker walker = new ParseTreeWalker();
		MyTaxFormListener listener = new MyTaxFormListener();
		walker.walk(listener, parser.form());
		
    	//System.out.println( "Start" );
    }
}
