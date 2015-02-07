package anotherOne.ast.question;

public interface IQuestionElementVisitor <T>{
	public T visit (BasicQuestion basic);
//	public T visit (visitCompleteQuestion);
}
