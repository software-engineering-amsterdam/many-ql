package qls.ast.statement.styling.property;

import java.util.Arrays;

import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.statement.styling.StyleRule;
import qls.ast.visitor.StatementVisitor;

public class Color extends StyleRule {
	public Color(Literal<?> value) {
		super(Arrays.asList(new QLInteger()), value);
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
