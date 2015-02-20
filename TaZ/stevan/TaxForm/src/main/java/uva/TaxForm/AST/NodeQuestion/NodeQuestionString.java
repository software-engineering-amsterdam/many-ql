package uva.TaxForm.AST.NodeQuestion;

import uva.TaxForm.AST.NodeVar.VarString;

public class NodeQuestionString extends NodeQuestion {

	private VarString var;

	public VarString getVar() {
		return var;
	}

	public void setVar(VarString var) {
		this.var = var;
	}
}
