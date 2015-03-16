package org.uva.sea.qls.encoders.visitor;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.uva.sea.ql.encoders.EncodersQLSBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLSParser.PageContext;
import org.uva.sea.qls.encoders.ast.AstNode;
import org.uva.sea.qls.encoders.ast.Page;
import org.uva.sea.qls.encoders.ast.TextLocation;

public class AstBuilder extends EncodersQLSBaseVisitor<AstNode> {

	@Override
	public Page visitPage(PageContext ctx) {

		String name = ctx.name.getText();

		TextLocation textLocation = getTextLocation(ctx);

		Page page = new Page(textLocation, name);

		return page;
	}

	private TextLocation getTextLocation(ParserRuleContext ctx) {
		Token start = ctx.getStart();
		int line = start.getLine();
		int column = start.getCharPositionInLine();
		return new TextLocation(line, column);
	}

}
