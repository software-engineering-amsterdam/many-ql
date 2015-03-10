package gui;

import evaluator.ValueRepository;
import gui.questions.ComputedQuestionUI;
import gui.questions.IQuestionUI;
import gui.questions.IfQuestionUI;
import gui.questions.SimpleQuestionUI;
import gui.widgets.IWidgetComponent;
import gui.widgets.WidgetVisitor;
import gui.widgets.listeners.EvaluateExpression;
import gui.widgets.listeners.Updater;

import javax.swing.JLabel;

import ast.expression.Expression;
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
		return simpleQuestion.getQuestionType().accept(
				new WidgetVisitor( 
						simpleQuestion.getQuestionId().getID(), 
						simpleQuestion.getQuestionText(), 
						simpleQuestion.getQuestionType(), 
						this.valueRepository
				)
		);
		
	}
	
	public Updater sendToUpdater(Expression expression) {
		return new Updater(expression, gui, valueRepository);
	}
	
	@Override
	public IQuestionUI visit(Question question) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public IQuestionUI visit(SimpleQuestion simpleQuestion) {
		SimpleQuestionUI sq = new SimpleQuestionUI(simpleQuestion.getQuestionId().getID(),
												   new JLabel(simpleQuestion.getQuestionText()), 
												   this.widget(simpleQuestion),
												   this.valueRepository);
		
		gui.putWidgetRepository(simpleQuestion.getQuestionId().getID(), sq);
		return sq;
	}

	@Override
	public IQuestionUI visit(ComputationQuestion calQuestion) {
		ComputedQuestionUI sq = new ComputedQuestionUI(calQuestion.getQuestionId().getID(),
													new JLabel(calQuestion.getQuestionText()), 
													this.widget(calQuestion),
													this.valueRepository,
													this.sendToUpdater(calQuestion.getExpression()).updatedValue());
		
		gui.putWidgetRepository(calQuestion.getQuestionId().getID(), sq);
		
		return sq;
	}
	
	@Override
	public IQuestionUI visit(IfStatement ifStatement) {
		IfQuestionUI ifq = new IfQuestionUI();
	
	
	//	ifStatement.getExpression();
	//	ifStatement.getIfStatement();
		for(Question q : ifStatement.getIfStatement()){
			System.out.println(q.getClass());
			IQuestionUI aQuestion = visit(q);
			System.out.println("visited "+q.getClass());
		}
		return ifq;
	}

	@Override
	public IQuestionUI visit(IfElseStatement ifElseStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
