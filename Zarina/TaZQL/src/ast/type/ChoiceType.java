package ast.type;

public class ChoiceType extends Type {
		

	public String getValue() {
		return "choice";
	}
			
	@Override
	public String toString() {
		return "choise";
	}
		
	@Override
	public <T> T accept(ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}	

}
