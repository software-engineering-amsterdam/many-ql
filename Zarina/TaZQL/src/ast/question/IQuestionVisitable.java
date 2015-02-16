package ast.question;

import ast.AST;


public abstract class IQuestionVisitable extends AST {
	
	public abstract <T> T accept(IQuestionVisitor<T> visitor);
		
}
