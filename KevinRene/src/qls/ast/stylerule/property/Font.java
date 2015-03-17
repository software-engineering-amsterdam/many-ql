package qls.ast.stylerule.property;

import java.util.Arrays;

import ql.ast.type.QLString;
import qls.ast.expression.Literal;
import qls.ast.stylerule.StyleRule;
import qls.ast.visitor.StatementVisitor;

public class Font extends StyleRule {
	public Font(Literal<?> value) {
		super(Arrays.asList(QLString.class), value);
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
