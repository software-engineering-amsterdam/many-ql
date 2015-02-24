package uva.TaxForm.AST.Nodes.NodeVar;

public class Var<T> extends NodeVar {

	private T value;
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}
