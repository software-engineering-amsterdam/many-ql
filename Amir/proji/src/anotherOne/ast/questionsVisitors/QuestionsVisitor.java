package anotherOne.ast.questionsVisitors;

import javax.swing.JFrame;

import anotherOne.ast.question.BasicQuestion;
import anotherOne.ast.question.ComputedQuestion;
import anotherOne.ast.question.IfQuestion;

public interface QuestionsVisitor<T> {
	
	public T visit (JFrame frame, BasicQuestion basQuest);
	public T visit (JFrame frame, ComputedQuestion compQuest);
	public T visit (JFrame frame, IfQuestion ifQuest);
}
