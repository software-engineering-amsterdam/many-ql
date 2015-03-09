package nl.uva.se.ast.type;

public class UndefinedType extends Type {

	public UndefinedType() {
		super("undefined");
	}

	@Override
	public boolean isUndefined() {
		return true;
	}
	
}
