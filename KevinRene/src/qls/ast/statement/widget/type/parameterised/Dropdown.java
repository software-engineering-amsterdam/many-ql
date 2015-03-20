package qls.ast.statement.widget.type.parameterised;

import java.util.Arrays;

import ql.ast.QLType;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLString;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.type.ParameterisedWidget;
import qls.ast.visitor.StatementVisitor;

public class Dropdown extends ParameterisedWidget {
	public Dropdown(Literal<?> trueValue, Literal<?> falseValue) {
		super(Arrays.asList(new QLBoolean()),
				Arrays.asList(new QLString()),
				trueValue,
				falseValue);
	}
	
	@Override
	public QLType getCompatibleValueType() {
		return new QLString();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Dropdown";
	}
}
