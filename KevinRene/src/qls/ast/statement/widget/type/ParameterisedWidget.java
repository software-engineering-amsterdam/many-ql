package qls.ast.statement.widget.type;

import java.util.List;

import ql.ast.QLType;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.WidgetType;

public abstract class ParameterisedWidget extends WidgetType  {
	private Literal<?> firstValue, secondValue;
	private List<QLType> compatibleParameterTypes;
	
	public ParameterisedWidget(List<QLType> compatibleTypes, 
			List<QLType> compatibleParameterTypes,
			Literal<?> trueValue, 
			Literal<?> falseValue) {
		super(compatibleTypes);		
		
		this.compatibleParameterTypes = compatibleParameterTypes;
		this.firstValue = trueValue;
		this.secondValue = falseValue;
	}

	public Literal<?> getFirstValue() {
		return firstValue;
	}
	
	public Literal<?> getSecondValue() {
		return secondValue;
	}
	
	public abstract QLType getCompatibleValueType();
	
	public boolean hasCompatibleValues() {
		if(!compatibleParameterTypes.contains(firstValue.getType())
				|| !compatibleParameterTypes.contains(secondValue.getType())) {
			return false;
		}
		
		return true;
	}
}