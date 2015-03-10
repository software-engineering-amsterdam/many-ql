package org.uva.ql.ast.questionnaire;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.QLNode;
import org.uva.ql.visitor.QuestionnaireVisitable;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.utility.CodePosition;

public class Questionnaire implements QLNode, QuestionnaireVisitable {

	private List<Form> forms;
	private final CodePosition position;

	public Questionnaire(CodePosition pos) {
		this.position = pos;
		forms = new ArrayList<Form>();
	}

	public CodePosition getPosition() {
		return position;
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
