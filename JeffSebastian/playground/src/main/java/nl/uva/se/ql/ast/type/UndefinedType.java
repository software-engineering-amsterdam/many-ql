package nl.uva.se.ql.ast.type;

public class UndefinedType extends Type {

	public UndefinedType() {
		super("undefined");
	}

	@Override
	public boolean isUndefined() {
		return true;
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
