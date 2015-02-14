package ast.type;


public abstract class TextType extends Type<String> {
	

	public String getValue() {
		return "text";
	}
	
	
	@Override
	public String toString() {
		return "text";
	}

}
