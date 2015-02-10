package cons.ql.ast.expression;

import cons.ql.ast.Expression;
import cons.ql.ast.Visitor;

public abstract class QLType<T> extends Expression {
	protected T value;
	protected boolean defined;
	
	public QLType() {
		defined = false;
	}
	
	public QLType(T value) {
		this.value = value;
		defined = true;
	}
	
	public void setValue(T value) { 
		this.value = value;
		defined = true;
	}
	
	public T getValue() throws NullPointerException {
		if(!defined)
			throw new NullPointerException("Variable not defined.");
		
		return value;
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public abstract String toString();
	
	@Override
	public abstract void accept(Visitor visitor);
}