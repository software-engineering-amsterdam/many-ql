package org.uva.ql.ast.questionnaire;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.visitor.QuestionnaireVisitable;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.utility.CodePosition;

public class Questionnaire extends BaseNode implements QuestionnaireVisitable {

	private List<Form> forms;

	public Questionnaire(CodePosition pos) {
		super(pos);
		forms = new ArrayList<Form>();
	}

	public void addForm(Form form) {
		forms.add(form);
	}

	public List<Form> getForms() {
		return forms;
	}

	@Override
	public <T> T accept(QuestionnaireVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	 
}
