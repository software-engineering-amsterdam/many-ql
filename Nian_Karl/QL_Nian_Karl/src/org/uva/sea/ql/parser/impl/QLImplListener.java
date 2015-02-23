package org.uva.sea.ql.parser.impl;

import org.uva.sea.ql.AST.Form;
import org.uva.sea.ql.factory.QLFactory;
import org.uva.sea.ql.parser.antlr.QLBaseListener;
import org.uva.sea.ql.parser.antlr.QLParser.IfStatementContext;
import org.uva.sea.ql.parser.antlr.QLParser.QuestionContext;
import org.uva.sea.ql.parser.antlr.QLParser.StatementContext;

public class QLImplListener extends QLBaseListener {

	private Form form;
	private QLFactory factory;

	public QLImplListener() {
		super();
		this.form = new Form();
		this.factory = new QLFactory();
	}

	@Override
	public void exitStatement(StatementContext ctx) {
		super.exitStatement(ctx);
	}
	
	@Override
	public void exitQuestion(QuestionContext ctx) {
		super.exitQuestion(ctx);
		
	}

	@Override
	public void exitIfStatement(IfStatementContext ctx) {
		super.exitIfStatement(ctx);
//		System.out.println(ctx.getText());
//		System.out.println(ctx.getParent().getText());
//		for (int i = 0; i < ctx.getChildCount(); i++) {
//			System.out.println(ctx.getChild(i).getText());
//			
//		}
	}
}
