package qls.ast.statement.widget.type.parameterised;

import java.util.Arrays;

import ql.ast.QLType;
import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLMoney;
import ql.ast.type.QLNumeric;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.type.ParameterisedWidget;
import qls.ast.visitor.StatementVisitor;

public class Slider extends ParameterisedWidget {
	public Slider(Literal<?> minValue, Literal<?> maxValue) {
		super(Arrays.asList(new QLFloat(), new QLInteger(), 
					new QLMoney(), new QLNumeric()),
				Arrays.asList(new QLFloat(), new QLInteger(),
						new QLMoney(), new QLNumeric()),
				minValue,
				maxValue);
	}
	
	@Override
	public QLType getCompatibleValueType() {
		return new QLNumeric();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Slider";
	}
}
