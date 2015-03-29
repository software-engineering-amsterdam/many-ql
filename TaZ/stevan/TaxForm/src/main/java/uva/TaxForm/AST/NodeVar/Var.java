package uva.TaxForm.AST.NodeVar;

public class Var<T> extends NodeVar {

	private T value;
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}
