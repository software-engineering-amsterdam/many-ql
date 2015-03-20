package uva.qls.ast.value;

public class BooleanValue extends GenericValue<Boolean> {
	
	private boolean value;
	
	public BooleanValue(boolean _value){
		this.value=_value;
	}

	@Override
	public Boolean getValue() {
		return this.value;
	}
}
