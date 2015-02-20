package uva.TaxForm.AST.NodeQuestion;

import uva.TaxForm.AST.NodeVar.VarInteger;

public class NodeQuestionInteger extends NodeQuestion {

	private VarInteger var;

	public VarInteger getVar() {
		return var;
	}

	public void setVar(VarInteger var) {
		this.var = var;
	}
}
