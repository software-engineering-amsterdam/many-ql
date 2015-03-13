package qls.ast.stylerule.property;

import java.util.Arrays;

import ql.ast.expression.type.QLString;
import qls.ast.stylerule.StyleProperty;
import qls.ast.visitor.QLSVisitor;

public class Color extends StyleProperty {
	public Color() {
		super(Arrays.asList(QLString.class));
	}

	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
