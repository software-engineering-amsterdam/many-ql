package uva.ql.ast.expressions;

public abstract class Type {
	
	String name;
	
	public Type(String _name){
		this.name = _name;
	}
	public String getType(){
		return this.name;
	}
}
