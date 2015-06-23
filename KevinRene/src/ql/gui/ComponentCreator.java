package ql.gui;

import ql.ast.Expression;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.MoneyLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLMoney;
import ql.ast.type.QLString;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.ast.visitor.TypeVisitor;
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.gui.content.UIComputedQuestion;
import ql.gui.content.UIConditional;
import ql.gui.content.UIQuestion;
import ql.gui.structure.Label;
import ql.gui.structure.Panel;
import ql.gui.widget.InputWidget;
import ql.gui.widget.input.RadioButton;
import ql.gui.widget.input.field.TextField;
import ql.gui.widget.input.spinbox.FloatSpinbox;
import ql.gui.widget.input.spinbox.IntegerSpinbox;
import ql.gui.widget.input.spinbox.MoneySpinbox;

public class ComponentCreator extends StatementVisitor<Component> implements ExpressionVisitor<Component>, TypeVisitor<Component> {	
	private ValueEnvironment valueEnvironment;

	private ComponentCreator(ValueEnvironment valueEnvironment) {
		this.valueEnvironment = valueEnvironment;
	}
	
	public static Component check(Expression tree, ValueEnvironment valueEnvironment) {		
		ComponentCreator creator = new ComponentCreator(valueEnvironment);
				
		return tree.accept(creator);
	}
	
	public static Component check(Statement tree, ValueEnvironment valueEnvironment) {		
		ComponentCreator creator = new ComponentCreator(valueEnvironment);
				
		return tree.accept(creator);
	}
	
	@Override
	public Component visit(Identifier identifier) {
		return new Panel();
	}
	
	@Override
	public Component visit(QLBoolean booleanNode) {
		return new RadioButton();
	}
	
	@Override
	public Component visit(QLFloat floatNode) {
		return new FloatSpinbox();
	}
	
	@Override
	public Component visit(QLMoney moneyNode) {
		return new MoneySpinbox();
	}
	
	@Override
	public Component visit(QLInteger integerNode) {
		return new IntegerSpinbox();
	}
	
	@Override
	public Component visit(QLString integerNode) {
		return new TextField();
	}
	
	@Override
	public Component visit(BooleanLiteral booleanLiteral) {
		return new RadioButton(booleanLiteral.getValue());
	}
	
	@Override
	public Component visit(FloatLiteral floatLiteral) {
		return new FloatSpinbox(floatLiteral.getValue());
	}
	
	@Override
	public Component visit(MoneyLiteral moneyNode) {
		return new MoneySpinbox(moneyNode.getValue());
	}
	
	@Override
	public Component visit(IntegerLiteral integerLiteral) {
		return new IntegerSpinbox(integerLiteral.getValue());
	}
	
	@Override
	public Component visit(StringLiteral stringNode) {
		return new Label(stringNode.getValue());
	}
	
	/**
	 * Statements
	 */	
	@Override
	public Component visit(Block blockNode) {
		Panel widgetPanel = new Panel();
		Component statementWidget;
		
		for(Statement statement : blockNode.getStatements()) {
			statementWidget = statement.accept(this);			
			widgetPanel.addComponent(statementWidget);
		}
		
		return widgetPanel;
	}
	
	@Override
	public Component visit(ComputedQuestion compQuestionNode) {
    	Component questionText = compQuestionNode.getText().accept(this);
    	InputWidget<?> questionWidget = (InputWidget<?>) compQuestionNode.getType().accept(this);
    	
    	return new UIComputedQuestion(compQuestionNode.getIdentifier(), questionText, 
    			questionWidget, compQuestionNode.getExpression(), valueEnvironment);
	}
	
	@Override
	public Component visit(Question questionNode) {
		Component questionText = questionNode.getText().accept(this);
    	Component questionWidget = questionNode.getType().accept(this);
    	
    	return new UIQuestion(questionNode.getIdentifier(), questionText, questionWidget, valueEnvironment);
	}
	
	@Override
	public Component visit(Form formNode) {
		Panel formSection = new Panel();
		formSection.addComponent(formNode.getBlock().accept(this));
		
		return formSection;
	}
	
	@Override
	public Component visit(If ifNode) {
		return new UIConditional(ifNode.getExpression(), valueEnvironment, (Panel) ifNode.getBlock().accept(this));
	}

	@Override
	public Component visit(IfElse ifElseNode) {		
		Panel elsePanel = (Panel) ifElseNode.getElseBranch().accept(this);
		Panel ifPanel = (Panel) ifElseNode.getIfBranch().accept(this);
		
		return new UIConditional(ifElseNode.getExpression(), valueEnvironment, ifPanel, elsePanel);
	}
}
