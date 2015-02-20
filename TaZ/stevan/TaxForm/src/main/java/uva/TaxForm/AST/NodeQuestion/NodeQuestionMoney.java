package uva.TaxForm.AST.NodeQuestion;

import uva.TaxForm.AST.NodeVar.VarMoney;

public class NodeQuestionMoney extends NodeQuestion {

	private VarMoney var;

	public VarMoney getVar() {
		return var;
	}

	public void setVar(VarMoney var) {
		this.var = var;
	}
}
