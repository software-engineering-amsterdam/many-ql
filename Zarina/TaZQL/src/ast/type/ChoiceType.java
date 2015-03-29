package ast.type;

public class ChoiceType extends Type {
	
	public ChoiceType() {}
			
	@Override
	public String toString() {
		return "choice";
	}
		
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public boolean isCompatibleToBoolean() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToBoolean();
	}
}
