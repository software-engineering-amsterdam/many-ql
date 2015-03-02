package gui;

import gui.questions.ComputedQuestionUI;
import gui.questions.IQuestionUI;
import gui.questions.SimpleQuestionUI;
import gui.widgets.IWidgetComponent;
import gui.widgets.WidgetVisitor;
import gui.widgets.listeners.EvaluateExpression;
import interpreter.ValueRepository;

import javax.swing.JLabel;

import ast.question.ComputationQuestion;
import ast.question.IQuestionVisitor;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;

public class GUIVisitor implements IQuestionVisitor<IQuestionUI>{
	private final GUIRender gui;
	private final ValueRepository valueRepository;
	private EvaluateExpression evaluator;

	public GUIVisitor(GUIRender gui, ValueRepository valueRepository) {
		this.gui = gui;
		this.valueRepository = valueRepository;
		evaluator = new EvaluateExpression(valueRepository);
	} 
	

	public IWidgetComponent widget(SimpleQuestion simpleQuestion) {
		return simpleQuestion.getQuestionType().accept(new WidgetVisitor( simpleQuestion.getQuestionId(), simpleQuestion.getQuestionText(), simpleQuestion.getQuestionType(), this.valueRepository));
		
	}
	
	@Override
	public IQuestionUI visit(Question question) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public IQuestionUI visit(SimpleQuestion simpleQuestion) {
		SimpleQuestionUI sq = new SimpleQuestionUI(simpleQuestion.getQuestionId(),
												   new JLabel(simpleQuestion.getQuestionText()), 
												   this.widget(simpleQuestion),
												   this.valueRepository);
		
		gui.putWidgetRepository(simpleQuestion.getQuestionId(), sq);
		sq.getValue();
		return sq;
	}

	@Override
	public IQuestionUI visit(ComputationQuestion calQuestion) {
		ComputedQuestionUI sq = new ComputedQuestionUI(calQuestion.getQuestionId(),
													new JLabel(calQuestion.getQuestionText()), 
													this.widget(calQuestion),
													this.valueRepository,
													evaluator.evaluate(calQuestion.getExpression()));
		gui.putWidgetRepository(calQuestion.getQuestionId(), sq);
		return sq;
	}
	
	@Override
	public IQuestionUI visit(IfStatement ifStatement) {
	//	IfStatementUI ifst = new IfStatementUI(ifStatement.getExpression());
		
	//	for(Question q : ifStatement.getIfStatement())
		// TODO Auto-generated method stub
	//	ifStatement.getExpression();
	//	ifStatement.getIfStatement();
		return null;
	}

	@Override
	public IQuestionUI visit(IfElseStatement ifElseStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
