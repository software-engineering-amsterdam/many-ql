package uva.TaxForm.AST.Nodes.NodeQuestion;

import uva.TaxForm.AST.Nodes.NodeVar.Var;

public class Question<T> extends NodeQuestion {

	private Var<T> var;

	public Var<T> getVar() {
		return this.var;
	}

	public void setVar(Var<T> var) {
		this.var = var;
	}
}
