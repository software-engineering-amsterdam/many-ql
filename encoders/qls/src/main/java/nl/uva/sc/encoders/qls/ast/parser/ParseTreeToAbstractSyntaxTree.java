package nl.uva.sc.encoders.qls.ast.parser;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.EncodersQLSBaseVisitor;
import nl.uva.sc.encoders.qls.EncodersQLSParser.PageContext;
import nl.uva.sc.encoders.qls.ast.AstNode;
import nl.uva.sc.encoders.qls.ast.Page;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class ParseTreeToAbstractSyntaxTree extends EncodersQLSBaseVisitor<AstNode> {

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
