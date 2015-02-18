package uva.ql.ast.expressions;

public abstract class Type<T> {
	T value;
	
	public Type(T _value){
		this.value = _value;
	}
	public T getType(){
		return this.value;
	}
}
