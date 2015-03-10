package uva.qls.interpreter.typecheck.table;

public abstract class Table <K,T>{
	
	public abstract void putValue(K identifier, T value);
	public abstract T retrieveValue(K identifier);
	public abstract String toString();

}
