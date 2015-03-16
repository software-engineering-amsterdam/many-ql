package qls.ast.stylerule.property;

import java.util.Arrays;

import ql.ast.expression.Literal;
import ql.ast.type.QLInteger;
import qls.ast.stylerule.StyleRule;
import qls.ast.visitor.QLSVisitor;

public class FontSize extends StyleRule {
	public FontSize(Literal<?> value) {
		super(Arrays.asList(QLInteger.class), value);
	}
	
	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
