package anotherOne.ast.question;

public interface IQuestionElement {

	public <T> T accept(IQuestionElementVisitor<T> visitor);
}
