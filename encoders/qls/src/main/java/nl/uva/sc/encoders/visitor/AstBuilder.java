package nl.uva.sc.encoders.visitor;

import nl.uva.sc.encoders.EncodersQLSBaseVisitor;
import nl.uva.sc.encoders.EncodersQLSParser.PageContext;
import nl.uva.sc.encoders.ast.AstNode;
import nl.uva.sc.encoders.ast.Page;
import nl.uva.sc.encoders.ast.TextLocation;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

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
