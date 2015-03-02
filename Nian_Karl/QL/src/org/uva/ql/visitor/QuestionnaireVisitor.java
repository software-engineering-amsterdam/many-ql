package org.uva.ql.visitor;

import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;

public interface QuestionnaireVisitor<T> {
	public T visit(Questionnaire questionnaire);

	public T visit(Form form);
}
