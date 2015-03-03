package gui;

import gui.widget.Label;
import gui.widget.composite.ComputedQuestionPanel;
import gui.widget.composite.FormComposite;
import gui.widget.composite.IfComposite;
import gui.widget.composite.Panel;
import gui.widget.composite.QuestionPanel;
import gui.widget.input.IntegerSpinbox;
import gui.widget.input.RadioButton;
import gui.widget.input.TextField;

import javax.swing.JFrame;

import cons.ValueEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.Statement;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.literal.BooleanLiteral;
import cons.ql.ast.expression.literal.IntegerLiteral;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.statement.Block;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.Form;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.IfElse;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class ComponentCreator implements StatementVisitor<Widget>, ExpressionVisitor<Widget> {	
	private JFrame frame;
	private ValueEnvironment valueEnvironment;

	private ComponentCreator(JFrame frame, ValueEnvironment valueEnvironment) {
		this.frame = frame;
		this.valueEnvironment = valueEnvironment;
	}
	
	public static Widget check(ASTNode tree, JFrame frame, ValueEnvironment valueEnvironment) {		
		ComponentCreator creator = new ComponentCreator(frame, valueEnvironment);
				
		return tree.accept(creator);
	}
	
	@Override
	public Widget visit(Identifier identifier) {
		return new Panel();
	}
	
	@Override
	public Widget visit(QLBoolean booleanNode) {
		return new RadioButton();
	}
	
	@Override
	public Widget visit(QLInteger integerNode) {
		return new IntegerSpinbox();
	}
	
	@Override
	public Widget visit(QLString integerNode) {
		return new TextField();
	}
	
	@Override
	public Widget visit(StringLiteral stringNode) {
		return new Label(stringNode.getValue());
	}
	
	@Override
	public Widget visit(IntegerLiteral integerLiteral) {
		return new IntegerSpinbox(integerLiteral.getValue());
	}
	
	@Override
	public Widget visit(BooleanLiteral booleanLiteral) {
		return new RadioButton(booleanLiteral.getValue());
	}
	
	/**
	 * Statements
	 */	
	@Override
	public Widget visit(Block blockNode) {
		Panel widgetPanel = new Panel();
		Widget statementWidget;
		
		for(Statement statement : blockNode.statements()) {
			statementWidget = statement.accept(this);			
			widgetPanel.addComponent(statementWidget);
		}
		
		return widgetPanel;
	}
	
	@Override
	public Widget visit(ComputedQuestion compQuestionNode) {
    	Widget questionText = compQuestionNode.getText().accept(this);
    	Widget questionWidget = compQuestionNode.getType().accept(this);
    	
    	return new ComputedQuestionPanel(compQuestionNode.getIdentifier(), questionText, 
    			questionWidget, compQuestionNode.getExpression(), valueEnvironment);
	}
	@Override
	public Widget visit(Question questionNode) {
		Widget questionText = questionNode.getText().accept(this);
    	Widget questionWidget = questionNode.getType().accept(this);
    	
    	return new QuestionPanel(questionNode.getIdentifier(), questionText, questionWidget, valueEnvironment);
	}
	
	@Override
	public Widget visit(Form formNode) {
		return new FormComposite(frame, formNode.getBlock().accept(this));
	}
	
	@Override
	public Widget visit(If ifNode) {
		return new IfComposite(ifNode.getExpression(), valueEnvironment, (Panel) ifNode.getBlock().accept(this));
	}

	@Override
	public Widget visit(IfElse ifElseNode) {		
		Panel elsePanel = (Panel) ifElseNode.getElseBranch().accept(this);
		Panel ifPanel = (Panel) ifElseNode.getIfBranch().accept(this);
		
		return new IfComposite(ifElseNode.getExpression(), valueEnvironment, ifPanel, elsePanel);
	}
}
