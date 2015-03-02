package gui;

import gui.questions.IConnector;
import gui.questions.SimpleQuestionUI;
import gui.widgets.IWidgetComponent;
import gui.widgets.WidgetVisitor;

import javax.swing.JLabel;

import ast.question.ComputationQuestion;
import ast.question.IQuestionVisitor;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;

public class GUIVisitor implements IQuestionVisitor<IConnector>{
	private final GUIRender gui;
	WidgetVisitor wid;

	public GUIVisitor(GUIRender gui) {
		this.gui = gui;
	} 
	
	public void addLabel(SimpleQuestion q) {
		//
			//this.gui.getLabel(q.getQuestionText());
			//System.out.print("Test: " + q.getQuestionText());
	}
	public IWidgetComponent widget(SimpleQuestion simpleQuestion) {
		return simpleQuestion.getQuestionType().accept(new WidgetVisitor( simpleQuestion.getQuestionId(), simpleQuestion.getQuestionText(), simpleQuestion.getQuestionType()));
		
	}
	
	@Override
	public IConnector visit(Question question) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public IConnector visit(SimpleQuestion simpleQuestion) {
		SimpleQuestionUI sq = new SimpleQuestionUI(simpleQuestion.getQuestionId(),
												   new JLabel(simpleQuestion.getQuestionText()), 
												   this.widget(simpleQuestion));
		
		gui.putWidgetRepository(simpleQuestion.getQuestionId(), sq);
		return sq;
	}

	@Override
	public IConnector visit(ComputationQuestion calQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IConnector visit(IfStatement ifStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IConnector visit(IfElseStatement ifElseStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
