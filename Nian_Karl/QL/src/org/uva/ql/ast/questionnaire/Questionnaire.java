package org.uva.ql.ast.questionnaire;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.visitor.Visitor;

public class Questionnaire implements Node {

	private List<Form> forms;
	
	public Questionnaire() {
		forms = new ArrayList<Form>();
	}
	
	public void addForm(Form form){
		forms.add(form);
	}
	
	public List<Form> getForms() {
		return forms;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
