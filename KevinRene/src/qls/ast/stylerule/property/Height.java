package qls.ast.stylerule.property;

import java.util.Arrays;

import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.stylerule.StyleRule;
import qls.ast.visitor.StatementVisitor;

public class Height extends StyleRule {
	public Height(Literal<?> value) {
		super(Arrays.asList(QLInteger.class), value);
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
