package uva.TaxForm;

import java.net.URL;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import uva.TaxForm.Utils.TreeTaxFormListener;
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
		
		ParseTreeWalker walker = new ParseTreeWalker();
		CommonTaxFormListener listener = new CommonTaxFormListener();
		//walker.walk(listener, parser.statement());
		
		TreeTaxFormListener treeFrame = new TreeTaxFormListener(parser);
		walker.walk(treeFrame, parser.taxForm());
		
		
		/*List<String> ruleNames = Arrays.asList(parser.getRuleNames());
		parser.setBuildParseTree(true);

		TreePrinterListener treeListener = new TreePrinterListener(ruleNames);
		ParseTreeWalker.DEFAULT.walk(treeListener, parser.form());
		String formatted = treeListener.toString();
		
		System.out.println(formatted);*/
		
    }
}
