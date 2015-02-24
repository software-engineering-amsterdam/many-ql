package ast.value;


public class Undefined extends Value {
	
	private static final Undefined UNDEFINED = new Undefined();
	
	public Undefined() {
		
	}
	
	@Override
	public Undefined getValue() {
		return UNDEFINED;
	}

	@Override
	public String toString() {
		return "Undefined";
	}

}
