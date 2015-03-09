package org.uva.ql.visitor;

public interface QuestionnaireVisitable {
	public <T> T accept(QuestionnaireVisitor<T> visitor);
}
