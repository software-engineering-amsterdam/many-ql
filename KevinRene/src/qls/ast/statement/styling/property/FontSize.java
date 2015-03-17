package qls.ast.statement.styling.property;

import java.util.Arrays;

import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.statement.styling.Property;
import qls.ast.visitor.StatementVisitor;

public class FontSize extends Property {
	public FontSize(Literal<?> value) {
		super(Arrays.asList(new QLInteger()), value);
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
