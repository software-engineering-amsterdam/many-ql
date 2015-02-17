package org.uva.sea.ql.parser.impl;

import org.uva.sea.ql.factory.QLFactory;
import org.uva.sea.ql.model.Form;
import org.uva.sea.ql.parser.antlr.QLBaseListener;
import org.uva.sea.ql.parser.antlr.QLParser.BlockContext;
import org.uva.sea.ql.parser.antlr.QLParser.IfStatementContext;
import org.uva.sea.ql.parser.antlr.QLParser.QuestionContext;
import org.uva.sea.ql.parser.antlr.QLParser.StatementContext;

public class QLImplListener extends QLBaseListener{

	private Form form;
	private QLFactory factory;
	public QLImplListener() {
		super();
		this.form = new Form();
		this.factory = new QLFactory();	
	}
	
	@Override
	public void exitQuestion(QuestionContext ctx) {
		super.exitQuestion(ctx);	
//		form.addStatement(factory.getQuestion(ctx));
	}
	
	@Override
	public void exitIfStatement(IfStatementContext ctx) {
		super.exitIfStatement(ctx);
	}
	@Override
	public void exitStatement(StatementContext ctx) {
		super.exitStatement(ctx);
		if (ctx.ifStatement() != null) {
			System.out.println("IFstatement");
		}
		
		if (ctx.question() != null) {
			if (ctx.ifStatement() != null) {
				System.out.println(ctx.ifStatement().getParent().getText());
			}
			
			System.out.println("QuestionStatement");
		}
	}
	
	@Override
	public void exitBlock(BlockContext ctx) {
		super.exitBlock(ctx);
		
	}
}
