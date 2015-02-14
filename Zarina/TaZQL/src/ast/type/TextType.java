package ast.type;


public class TextType extends Type {
	
	public String getType() {
		return "text";
	}
	
	@Override
	public String toString() {
		return "text";
	}
	
	 @Override
	 public <T> T accept(ITypeVisitor<T> visitor) {
		 return visitor.visit(this);
	 }

}
