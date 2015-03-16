package ast.question;

import ast.AST;


public abstract class Question extends AST {
	
	public abstract String toString();

	public abstract <T> T accept(IQuestionVisitor<T> visitor);

}
