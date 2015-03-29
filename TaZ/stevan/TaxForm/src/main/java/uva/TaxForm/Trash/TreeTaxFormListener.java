package uva.TaxForm.Trash;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.Trees;

public class TreeTaxFormListener implements ParseTreeListener {
	
	private final List<String> ruleNames;
	private Parser parser;
	
	public TreeTaxFormListener(Parser parser) {
		
		this.parser = parser;
		//this.ruleNames = Arrays.asList(parser.getRuleNames());
		this.ruleNames = Arrays.asList( "taxForm", "statement", "atom", "question", 
										"varName", "varType" ); 
		
		System.out.println( "depth -> childCount -> ruleIndex -> ruleContext -> startType -> Text" );
		
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		
		/*System.out.println( ctx.depth() + "\t" + ctx.getChildCount() + "\t" 
							+ ctx.getRuleIndex() + "\t" + ctx.getRuleContext() + 
								"\t" + ctx.getStart().getType() + " -> " + ctx.getText() );*/
		
		for(String name: ruleNames) {
			if( parser.getRuleIndex(name) == ctx.getRuleIndex() ) {
				System.out.println( ctx.depth() + "\t" + ctx.getChildCount() + "\t" 
									+ ctx.getRuleIndex() + "\t" + ctx.getRuleContext() + 
									"\t" + ctx.getStart().getType() + " -> " + ctx.getText() );
			}
		}
		//System.out.println( ctx.toStringTree() );
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
		//System.out.println( "visitTerminal: " + Trees.toStringTree(node) );
		System.out.println( "visitTerminal: " + node.getText() );
	}
}
