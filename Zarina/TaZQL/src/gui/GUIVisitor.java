package gui;

import interpreter.ValueRepository;
import gui.trash.SimpleQuestionUI;
import gui.widgets.IWidgetComponent;
import gui.widgets.WidgetVisitor;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import ast.expression.BracketsExpression;
import ast.expression.arithmetic.AdditionExpression;
import ast.expression.arithmetic.DivisionExpression;
import ast.expression.arithmetic.MultiplicationExpression;
import ast.expression.arithmetic.SubstractionExpression;
import ast.expression.comparison.EqualExpression;
import ast.expression.comparison.GreaterEqualExpression;
import ast.expression.comparison.GreaterThanExpression;
import ast.expression.comparison.LessEqualExpression;
import ast.expression.comparison.LessThanExpression;
import ast.expression.comparison.NotEqualExpression;
import ast.expression.logical.AndExpression;
import ast.expression.logical.OrExpression;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.Id;
import ast.expression.variables.IntegerVariable;
import ast.expression.variables.StringVariable;
import ast.form.Form;
import ast.form.IFormVisitor;
import ast.question.ComputationQuestion;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;
import ast.type.ChoiceType;
import ast.type.DigitsType;
import ast.type.TextType;
import ast.type.UndefinedType;
import ast.unary.MinusExpression;
import ast.unary.NotExpression;
import ast.unary.PlusExpression;

public class GUIVisitor extends JPanel implements IFormVisitor<Void> {
	private JPanel panel;
	private IWidgetComponent c;
	WidgetVisitor wv;
	SimpleQuestionUI simp;
	ValueRepository valueRepository;
	
	public static JPanel maker(Form form) {
		GUIVisitor visitor = new GUIVisitor();
		form.accept(visitor);
		return visitor.getPanel();
	}
	
	public GUIVisitor() {
		this.panel = new JPanel();
		this.panel.setLayout(new MigLayout("wrap 2")); 
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void attachPanel(JPanel attachedPanel) {
		this.panel.add(attachedPanel);
	}
	
	public void getLabel(String text) {
		this.panel.add(new JLabel(text));
		this.panel.setVisible(true);
	}
	
	//to be changed in widget
	public JComponent addWidget(IWidgetComponent co) { 
		this.panel.add(co.getWidget(), "wrap");
		this.panel.setVisible(true); //temporary
		return panel;
	}
	
	public void visibility(Boolean visibilityValue) {
		this.panel.setVisible(visibilityValue);
	}
	
	// ***** visitor's part *****

	@Override
	public Void visit(Form form) {
		for(Question q : form.getQuestionText())
			q.accept(this);
		System.out.print("*  ");
		//this.panel.setVisible(true);
		return null;
	}
	
	@Override
	public Void visit(Question question) {
		
		return null;
	}

	public IWidgetComponent widget(SimpleQuestion simpleQuestion) {
		return simpleQuestion.getQuestionType().accept(new WidgetVisitor( simpleQuestion.getQuestionId(), simpleQuestion.getQuestionText(), simpleQuestion.getQuestionType(), valueRepository));
		
	}
	@Override
	public Void visit(SimpleQuestion simpleQuestion) {
		getLabel(simpleQuestion.getQuestionText());
		addWidget(widget(simpleQuestion));
		//SimpleQuestionUI simp = new SimpleQuestionUI();
		//Connector conny = new Connector(this);
		//conny.widget(simpleQuestion);
		
		//this.panel.add(conny.widget(simpleQuestion).getWidget());
		System.out.print("Test: are you working or what");
		//IQuestions q;
		//this.panel.add(simp.createdLabel(), "wrap");
		
	//	getLabel(simpleQuestion.getQuestionText());
		
		//new Connector().widget(simpleQuestion);
	//	System.out.println("q:");
	//	this.panel.add(simp.createdLabel(), "wrap");
	//	SimpleQuestion sq = new SimpleQuestion(simpleQuestion.getQuestionId(),simpleQuestion.getQuestionText(), simpleQuestion.getQuestionType());
	//	c.setIdWidget(simpleQuestion.getQuestionId());
	//	c.setLabel(simpleQuestion.getQuestionText());
	//	c.setWidgetType(simpleQuestion.getQuestionType());
	//	this.panel.add(sq.g, "wrap");
	//	this.panel.setVisible(true); //temporary
	//	visibility(true);
	//	attachEvent('onUnfocus', call_update_symboltable_with_its_data());
		return null;
	}

	@Override
	public Void visit(ComputationQuestion calQuestion) {
	//	getLabel(calQuestion.getQuestionText());
	//	addWidget(calQuestion.getQuestionId());
	//	visibility(false);
		return null;
	}

	@Override
	public Void visit(IfStatement ifStatement) {
		return null;
	}

	@Override
	public Void visit(IfElseStatement ifElseStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(BracketsExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(MultiplicationExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(DivisionExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(AdditionExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(SubstractionExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(EqualExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(NotEqualExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(LessThanExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(GreaterThanExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(LessEqualExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(GreaterEqualExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(NotExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(PlusExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(MinusExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(AndExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(OrExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(StringVariable string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IntegerVariable integer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(BooleanVariable bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Id identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(TextType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(DigitsType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ChoiceType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(UndefinedType type) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
