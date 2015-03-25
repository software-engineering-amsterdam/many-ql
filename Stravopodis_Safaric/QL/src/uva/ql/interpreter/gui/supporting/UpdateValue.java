package uva.ql.interpreter.gui.supporting;

import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.value.GenericValue;
import uva.ql.supporting.Tuple;

public class UpdateValue {

	private Tuple<Identifier, GenericValue<?>> updateValue;
	
	public UpdateValue(Identifier identifier, GenericValue<?> updateValue){
		this.updateValue = new Tuple<Identifier, GenericValue<?>>(identifier, updateValue);
	}
	
	public Identifier getIdentifier(){
		return this.updateValue.getX();
	}
	
	public GenericValue<?> getUpdateValue(){
		return this.updateValue.getY();
	}
}
