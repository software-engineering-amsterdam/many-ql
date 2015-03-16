package qls.ast.stylerule.property;

import java.util.Arrays;

import ql.ast.expression.Literal;
import ql.ast.type.QLString;
import qls.ast.stylerule.StyleRule;
import qls.ast.visitor.QLSVisitor;

public class Color extends StyleRule {
	public Color(Literal<?> value) {
		super(Arrays.asList(QLString.class), value);
	}

	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
