package anotherOne.gui.userInterface;

import anotherOne.ast.question.BasicQuestion;
import anotherOne.ast.question.ComputedQuestion;
import anotherOne.ast.question.IfQuestion;

public interface IQuestionElementVisitor <T> {

	public T visit(IfQuestion ifQuestion);
    public T visit(BasicQuestion basic);
    public T visit(ComputedQuestion computedQeustion);
}
