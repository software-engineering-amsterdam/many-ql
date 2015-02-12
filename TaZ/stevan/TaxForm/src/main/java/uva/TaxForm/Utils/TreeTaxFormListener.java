package uva.TaxForm.Utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TreeTaxFormListener implements ParseTreeListener {
	
	private final List<String> ruleNames;
	private Parser parser;
	
	public TreeTaxFormListener(Parser parser) {
		
		this.parser = parser;
		//this.ruleNames = Arrays.asList(parser.getRuleNames());
		this.ruleNames = Arrays.asList("form", "formName", "question", "iF"); 
		
		System.out.println( "depth -> ruleIndex -> ruleContext -> startType -> childCount -> Text" );
		
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println( "enterEveryRule: " + ctx.getText() );
		System.out.println( ctx.depth() + " -> " + ctx.getRuleIndex() + " -> " + ctx.getRuleContext() + " -> " + ctx.getStart().getType() + 
								" -> " + ctx.getChildCount() + " -> " + ctx.getText() );
		
		//System.out.println( ctx.depth() );
		
		for(String name: ruleNames) {
			if( parser.getRuleIndex(name) == ctx.getRuleIndex() ) {
				System.out.println( "exitEveryRule: " + ctx.getText() );
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		System.out.println( "visitErrorNode: " + node.getText() );
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		//System.out.println( "visitTerminal: " + node.getText() );
	}
}
