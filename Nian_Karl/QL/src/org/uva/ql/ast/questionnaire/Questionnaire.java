package org.uva.ql.ast.questionnaire;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.visitor.Visitor;

public class Questionnaire implements Node {

	private List<Form> formList;
	
	public Questionnaire() {
		formList = new ArrayList<Form>();
	}
	
	public void addForm(Form form){
		formList.add(form);
	}
	
	public List<Form> getFormList() {
		return formList;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
