package ast;

import ast.question.IQuestionVisitor;

public interface IMainVisitable {
	
	public <T> T accept(IQuestionVisitor<T> visitor);
		
}
