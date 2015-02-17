package ast.question;


public abstract class Question extends IQuestionVisitable {
	
	public abstract String toString();

	public abstract <T> T accept(IQuestionVisitor<T> visitor);

}
