package org.taz.exercises.TaZQL;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class MyTaZQLListener extends TaZQLBaseListener {
	
	
	@Override public void enterInit(TaZQLParser.InitContext ctx) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Tax Return Form");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Override public void exitInit(TaZQLParser.InitContext ctx) { 
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Override public void enterPage(TaZQLParser.PageContext ctx) {
		
	}

	@Override public void exitPage(TaZQLParser.PageContext ctx) { }
	
	@Override public void enterTitle(TaZQLParser.TitleContext ctx) { 
		
		System.out.println("\tTitle: " + ctx.STRING());
	}
	
	@Override public void exitTitle(TaZQLParser.TitleContext ctx) {
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	@Override public void enterContent(TaZQLParser.ContentContext ctx) {
		
	}
	
	@Override public void exitContent(TaZQLParser.ContentContext ctx) {
		
	}
	
	@Override public void enterQuestion(TaZQLParser.QuestionContext ctx) { 
		
		System.out.println("Qustion: " + ctx.STRING());
	}
	
	@Override public void exitQuestion(TaZQLParser.QuestionContext ctx) { }
	
	@Override public void enterAnswer(TaZQLParser.AnswerContext ctx) {
		
		System.out.println("Answer: " + ctx.STRING());
		System.out.println("+++");
	}
	
	@Override public void exitAnswer(TaZQLParser.AnswerContext ctx) { 
		
	}

	@Override public void enterEveryRule(ParserRuleContext ctx) { }

	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }

}
