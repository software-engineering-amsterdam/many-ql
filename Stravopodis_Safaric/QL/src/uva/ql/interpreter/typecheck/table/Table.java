package uva.ql.interpreter.typecheck.table;


public abstract class Table <K,T>{

	public abstract void putValue(K identifier, T value);
	public abstract boolean keyExists(K identifier);
	public abstract boolean valueExists(K identifier, T value);
	public abstract T retrieveValue(K identifier);
	public abstract String toString();
	
}
