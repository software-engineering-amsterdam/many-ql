package qls.ast;


public abstract class Literal<T> implements QLSNode {
	private final T value;
	
	public Literal(T value) {
		this.value = value;
	}
	
	public abstract QLSType getType();
	
	public T getValue() {
		return this.value;
	}	
	
	@Override
	public String toString() {
		return value.toString();
	}
}
