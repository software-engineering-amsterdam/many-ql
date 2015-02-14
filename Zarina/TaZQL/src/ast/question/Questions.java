package ast.question;

import ast.IMainVisitable;

public abstract class Questions implements IMainVisitable {
	public abstract <T> T accept(IQuestionVisitor<T> visitor);

}
