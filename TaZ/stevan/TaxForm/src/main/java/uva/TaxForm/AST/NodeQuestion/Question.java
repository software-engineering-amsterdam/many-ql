package uva.TaxForm.AST.NodeQuestion;

import uva.TaxForm.AST.NodeVar.Var;

public class Question<T> extends NodeQuestion {

	private Var<T> var;

	public Var<T> getVar() {
		return this.var;
	}

	public void setVar(Var<T> var) {
		this.var = var;
	}
}
