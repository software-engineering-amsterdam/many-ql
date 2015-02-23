package org.uva.sea.ql.encoders.service;

import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalContext;

public class ConditionalVisitor extends EncodersQLBaseVisitor<String> {

	@Override
	public String visitConditional(ConditionalContext ctx) {
		visitChildren(ctx);
		return ctx.getText();
	}
}
