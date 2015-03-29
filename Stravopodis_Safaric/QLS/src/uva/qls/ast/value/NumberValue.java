package uva.qls.ast.value;

public class NumberValue extends GenericValue<Integer> {
	
	private int value;
	
	public NumberValue(int _value){
		this.value=_value;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}
}
