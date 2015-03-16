package uva.ql.supporting.table;


public abstract class Table <K,T>{

	public abstract void putValue(K key, T value);
	public abstract boolean keyExists(K key);
	public abstract boolean valueExists(K key, T value);
	public abstract T retrieveValue(K key);
	public abstract String toString();
	
}
