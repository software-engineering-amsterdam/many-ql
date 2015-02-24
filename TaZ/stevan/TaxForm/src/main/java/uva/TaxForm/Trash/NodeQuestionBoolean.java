package uva.TaxForm.Trash;

import uva.TaxForm.AST.Nodes.NodeQuestion.NodeQuestion;

public class NodeQuestionBoolean extends NodeQuestion {

	private VarBoolean var;

	public VarBoolean getVar() {
		return var;
	}

	public void setVar(VarBoolean var) {
		this.var = var;
	}
}
