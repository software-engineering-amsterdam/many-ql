package uva.TaxForm.Trash;

import uva.TaxForm.AST.Nodes.NodeQuestion.NodeQuestion;

public class NodeQuestionString extends NodeQuestion {

	private VarString var;

	public VarString getVar() {
		return var;
	}

	public void setVar(VarString var) {
		this.var = var;
	}
}
