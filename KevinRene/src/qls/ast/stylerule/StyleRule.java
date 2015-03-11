package qls.ast.stylerule;

import ql.ast.expression.Literal;
import qls.ast.QLSStatement;
import qls.ast.visitor.QLSVisitor;

public class StyleRule extends QLSStatement {
	
	StyleProperty property;
	Literal<?> value;
	
	public StyleRule(StyleProperty property, Literal<?> value) {
		this.property = property;
		this.value = value;
	}

	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return property.toString() + ": " + value.getValue();
	}

}
