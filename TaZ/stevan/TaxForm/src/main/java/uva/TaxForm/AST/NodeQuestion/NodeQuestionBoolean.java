package uva.TaxForm.AST.NodeQuestion;

import uva.TaxForm.AST.NodeVar.VarBoolean;

public class NodeQuestionBoolean extends NodeQuestion {

	private VarBoolean var;

	public VarBoolean getVar() {
		return var;
	}

	public void setVar(VarBoolean var) {
		this.var = var;
	}
}
