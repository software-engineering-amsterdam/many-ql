package gui;

import gui.content.UIComputedQuestion;
import gui.content.UIConditional;
import gui.content.UIQuestion;
import gui.screen.FormScreen;
import gui.structure.Label;
import gui.structure.Panel;
import gui.widget.input.RadioButton;
import gui.widget.input.TextField;
import gui.widget.input.spinbox.FloatSpinbox;
import gui.widget.input.spinbox.IntegerSpinbox;
import ql.ValueEnvironment;
import ql.ast.Expression;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.type.QLBoolean;
import ql.ast.expression.type.QLFloat;
import ql.ast.expression.type.QLInteger;
import ql.ast.expression.type.QLString;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;

public class ComponentCreator extends StatementVisitor<Widget> implements ExpressionVisitor<Widget> {	
	private ValueEnvironment valueEnvironment;

	private ComponentCreator(ValueEnvironment valueEnvironment) {
		this.valueEnvironment = valueEnvironment;
	}
	
	public static Widget check(Expression tree, ValueEnvironment valueEnvironment) {		
		ComponentCreator creator = new ComponentCreator(valueEnvironment);
				
		return tree.accept(creator);
	}
	
	public static Widget check(Statement tree, ValueEnvironment valueEnvironment) {		
		ComponentCreator creator = new ComponentCreator(valueEnvironment);
				
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
	public Widget visit(QLFloat floatNode) {
		return new FloatSpinbox();
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
	public Widget visit(BooleanLiteral booleanLiteral) {
		return new RadioButton(booleanLiteral.getValue());
	}
	
	@Override
	public Widget visit(FloatLiteral floatLiteral) {
		return new FloatSpinbox(floatLiteral.getValue());
	}
	
	@Override
	public Widget visit(IntegerLiteral integerLiteral) {
		return new IntegerSpinbox(integerLiteral.getValue());
	}
	
	@Override
	public Widget visit(StringLiteral stringNode) {
		return new Label(stringNode.getValue());
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
    	
    	return new UIComputedQuestion(compQuestionNode.getIdentifier(), questionText, 
    			questionWidget, compQuestionNode.getExpression(), valueEnvironment);
	}
	@Override
	public Widget visit(Question questionNode) {
		Widget questionText = questionNode.getText().accept(this);
    	Widget questionWidget = questionNode.getType().accept(this);
    	
    	return new UIQuestion(questionNode.getIdentifier(), questionText, questionWidget, valueEnvironment);
	}
	
	@Override
	public Widget visit(Form formNode) {
		return new FormScreen(formNode.getBlock().accept(this));
	}
	
	@Override
	public Widget visit(If ifNode) {
		return new UIConditional(ifNode.getExpression(), valueEnvironment, (Panel) ifNode.getBlock().accept(this));
	}

	@Override
	public Widget visit(IfElse ifElseNode) {		
		Panel elsePanel = (Panel) ifElseNode.getElseBranch().accept(this);
		Panel ifPanel = (Panel) ifElseNode.getIfBranch().accept(this);
		
		return new UIConditional(ifElseNode.getExpression(), valueEnvironment, ifPanel, elsePanel);
	}
}
