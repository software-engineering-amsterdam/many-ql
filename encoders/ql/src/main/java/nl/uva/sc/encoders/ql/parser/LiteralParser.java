package nl.uva.sc.encoders.ql.parser;

import nl.uva.sc.encoders.ql.EncodersQLBaseVisitor;
import nl.uva.sc.encoders.ql.EncodersQLParser.BooleanLiteralContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.IntegerLiteralContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.StringLiteralContext;
import nl.uva.sc.encoders.ql.ast.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.literal.Literal;
import nl.uva.sc.encoders.ql.ast.literal.StringLiteral;

public class LiteralParser extends EncodersQLBaseVisitor<Literal> {

	@Override
	public BooleanLiteral visitBooleanLiteral(BooleanLiteralContext ctx) {
		Boolean value = Boolean.valueOf(ctx.getText());
		return new BooleanLiteral(value);
	}

	@Override
	public IntegerLiteral visitIntegerLiteral(IntegerLiteralContext ctx) {
		Integer value = Integer.valueOf(ctx.getText());
		return new IntegerLiteral(value);
	}

	@Override
	public StringLiteral visitStringLiteral(StringLiteralContext ctx) {
		String value = ctx.getText();
		return new StringLiteral(value);
	}
}
