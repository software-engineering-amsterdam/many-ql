package qls.ast.stylerule.property;

import java.util.Arrays;

import ql.ast.expression.type.QLInteger;
import qls.ast.stylerule.StyleProperty;
import qls.ast.visitor.QLSVisitor;

public class Height extends StyleProperty {
	public Height() {
		super(Arrays.asList(QLInteger.class));
	}
	
	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
