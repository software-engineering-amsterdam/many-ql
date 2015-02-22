package ast.type;

public class DigitsType extends Type {
		
	public String getValue() {
		return "digits";
	}
			
	@Override
	public String toString() {
		return "digits";
	}
		
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		 return visitor.visit(this);
	}
}
