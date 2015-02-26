package gui;

import gui.widgets.IWidgetComponent;
import gui.widgets.WidgetVisitor;

import javax.swing.JLabel;

import ast.question.ComputationQuestion;
import ast.question.IQuestionVisitor;
import ast.question.IQuestions;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;

public class Connector implements  IQuestionVisitor<IQuestions>{
	private final GUIVisitor gui;

	public Connector(GUIVisitor gui) {
		this.gui = gui;
	} 
	
	public void addStuff(SimpleQuestion q) {
			this.gui.getLabel(q.getQuestionText());
			System.out.print("Test: " + q.getQuestionText());
	}
	public IWidgetComponent widget(SimpleQuestion simpleQuestion) {
		return simpleQuestion.getQuestionType().accept(new WidgetVisitor(simpleQuestion.getQuestionId(), simpleQuestion.getQuestionText(), simpleQuestion.getQuestionType()));
	
	}
	
	@Override
	public IQuestions visit(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleQuestionUI visit(SimpleQuestion simpleQuestion) {
		SimpleQuestionUI sq = new SimpleQuestionUI(simpleQuestion.getQuestionId(),simpleQuestion.getQuestionText(), this.widget(simpleQuestion));
		addStuff(simpleQuestion);
		return sq;
	}

	@Override
	public IQuestions visit(ComputationQuestion calQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestions visit(IfStatement ifStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQuestions visit(IfElseStatement ifElseStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
