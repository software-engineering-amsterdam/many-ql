package uva.TaxForm.Trash;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.TaxForm.GUI.GUI;
import uva.TaxForm.antlr4.TaxFormBaseListener;
import uva.TaxForm.antlr4.TaxFormParser;

public class CommonTaxFormListener extends TaxFormBaseListener {
	
	private final List<String> ruleNames;
	private Parser parser;
	
	public CommonTaxFormListener(Parser parser) {
		
		this.parser = parser;
		//this.ruleNames = Arrays.asList(parser.getRuleNames());
		this.ruleNames = Arrays.asList( "form", "iF", "expression", 
										"question", 
										"varName", "varType" ); 
		
		//System.out.println( "depth -> childCount -> ruleIndex -> invokingState -> children -> ruleContext -> startType -> Text" );
		System.out.println( "depth -> childCount -> ruleName -> parent.invokingState -> invokingState -> Text" );
		
	}
	
	/*@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		
		System.out.println( ctx.depth() + "\t" + ctx.getChildCount() + "\t" 
							+ ctx.getRuleIndex() + "\t" + ctx.invokingState + "\t" 
							+ ctx.children + "\t" + ctx.getRuleContext() + 
								"\t" + ctx.getStart().getType() + " -> " + ctx.getText() );
		//System.out.println( ctx.children );
		
		for(String name: ruleNames) {
			if( parser.getRuleIndex(name) == ctx.getRuleIndex() ) {
				System.out.println( ctx.depth() + "\t" + ctx.getChildCount() + "\t" 
									+ ctx.getRuleIndex() + "\t" + ctx.getRuleContext() + 
									"\t" + ctx.getStart().getType() + " -> " + ctx.getText() );
			}
		}
		//System.out.println( ctx.toStringTree() );
	}*/
	
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		
		/*System.out.println( ctx.depth() + "\t" + ctx.getChildCount() + "\t" 
							+ ctx.getRuleIndex() + "\t" + ctx.invokingState + "\t" 
							+ ctx.children + "\t" +ctx.getText() );*/
		//System.out.println( ctx.start );
		
		for(String name: ruleNames) {
			if( parser.getRuleIndex(name) == ctx.getRuleIndex() ) {
				//System.out.println( name );
				System.out.println( ctx.depth() + "\t" + ctx.getChildCount() + "\t" 
							+ name.substring( 0, (name.length()>7)?7:name.length() ) + "\t"
							+ ctx.parent.invokingState + "\t" + ctx.invokingState + "\t"
							+ ctx.getText() );
			}
		}
	}
	
	/*public void enterTaxForm(TaxFormParser.TaxFormContext ctx) {
		
		System.out.println( "FORM:\t" + ctx.form().getText() );
		System.out.println( "FORM:\t" + ctx.atom().getText() );
		System.out.println( ctx.depth() + "\t" + ctx.getChildCount() + "\t" 
								+ ctx.getRuleIndex() + "\t" + ctx.getRuleContext() + 
								"\t" + ctx.getStart().getType() + " -> " + ctx.getText() );
		
		System.out.println("FORM: " + ctx.qna().toString());
	}*/
	
	/*public void enterIf_statement(TaxFormParser.If_statementContext ctx) {
		
		System.out.println( "If_statement:\t" + ctx.getText() );
		System.out.println( "If_statement:\t" + ctx.getRuleIndex() );
		System.out.println( "If_statement:\t" + ctx.getRuleContext() );
		System.out.println( "If_statement:\t" + ctx.getRuleContext().parent.invokingState );
		System.out.println( "If_statement:\t" + ctx.children );
		
		for ( Iterator<ParseTree> d = ctx.children.iterator(); d.hasNext(); ) {
			
			System.out.println( d.next().getPayload() );
		}
	}*/
	
	/*public void enterExpressionAtom(TaxFormParser.ExpressionAtomContext ctx) {
		
		System.out.println( "ExpressionAtom:\t" + ctx.getText() );
		System.out.println( "ExpressionAtom:\t" + ctx.getRuleIndex() );
		System.out.println( "ExpressionAtom:\t" + ctx.getRuleContext() );
		System.out.println( "ExpressionAtom:\t" + ctx.getRuleContext().parent.invokingState );
		System.out.println( "ExpressionAtom:\t" + ctx.children );
		
		for ( Iterator<ParseTree> d = ctx.children.iterator(); d.hasNext(); ) {
			
			System.out.println( d.next().getPayload() );
		}
	}*/
	
	/*public void enterAtomExpression(TaxFormParser.AtomExpressionContext ctx) {
		
		System.out.println( "AtomExpression:\t" + ctx.getText() );
		System.out.println( "AtomExpression:\t" + ctx.getRuleIndex() );
		System.out.println( "AtomExpression:\t" + ctx.getRuleContext() );
		System.out.println( "AtomExpression:\t" + ctx.getRuleContext().parent.invokingState );
		System.out.println( "AtomExpression:\t" + ctx.children );
		
		for ( Iterator<ParseTree> d = ctx.children.iterator(); d.hasNext(); ) {
			
			System.out.println( d.next().getPayload() );
		}
	}*/
	
	/*public void enterBoolAtom(TaxFormParser.BoolAtomContext ctx) {
		
		System.out.println( "BoolAtom:\t" + ctx.getText() );
		System.out.println( "BoolAtom:\t" + ctx.getRuleIndex() );
		System.out.println( "BoolAtom:\t" + ctx.getRuleContext() );
		System.out.println( "BoolAtom:\t" + ctx.getRuleContext().parent.invokingState );
		System.out.println( "BoolAtom:\t" + ctx.children );
		
		for ( Iterator<ParseTree> d = ctx.children.iterator(); d.hasNext(); ) {
			
			System.out.println( d.next().getPayload() );
		}
	}*/
	
	/*public void enterQuestion(TaxFormParser.QuestionContext ctx) {
		
		System.out.println( "Question:\t" + ctx.getText() );
		System.out.println( "Question:\t" + ctx.getRuleIndex() );
		System.out.println( "Question:\t" + ctx.getRuleContext() );
		System.out.println( "Question:\t" + ctx.getRuleContext().parent.invokingState );
		System.out.println( "Question:\t" + ctx.children );
		
		for ( Iterator<ParseTree> d = ctx.children.iterator(); d.hasNext(); ) {
			
			System.out.println( d.next().getPayload() );
		}
	}*/
	
	/*public void enterAnswer(TaxFormParser.AnswerContext ctx) {
		
		System.out.println( "Answer:\t" + ctx.getText() );
		System.out.println( "Answer:\t" + ctx.getRuleIndex() );
		System.out.println( "Answer:\t" + ctx.getRuleContext() );
		System.out.println( "Answer:\t" + ctx.getRuleContext().parent.invokingState );
		System.out.println( "Answer:\t" + ctx.children );
		
		for ( Iterator<ParseTree> d = ctx.children.iterator(); d.hasNext(); ) {
			
			System.out.println( d.next().getPayload() );
		}
	}*/
	
	
	/*public void enterQuestion(TaxFormParser.QuestionContext ctx) {
		
		System.out.println("Question: " + ctx.getText());
		//System.out.println("enterQuestion.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}
	
	public void enterAnswer(TaxFormParser.AnswerContext ctx) {
		
		System.out.println("Answer: " + ctx.getText());
		//System.out.println("enterAnswer.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}
	
	public void enterVarName(TaxFormParser.VarNameContext ctx) {
		
		System.out.println("varName: " + ctx.getText());
		//System.out.println("enterVariableName.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}
	
	public void enterVarType(TaxFormParser.VarTypeContext ctx) {
		
		System.out.println("varType: " + ctx.getText());
		//System.out.println("enterVariableName.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}*/
}
