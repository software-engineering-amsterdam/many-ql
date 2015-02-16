package cons.ql.ast.expression;

import cons.ql.ast.Expression;
 
public abstract class QLType<T> extends Expression {
	protected T value;
	protected boolean defined;
	
	public QLType() {}
	
	public QLType(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
}