package gui;

import gui.content.UIComputedQuestion;
import gui.content.UIConditional;
import gui.content.UIQuestion;
import gui.structure.Label;
import gui.structure.Section;
import gui.widget.InputWidget;
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

public class ComponentCreator extends StatementVisitor<UIComponent> implements ExpressionVisitor<UIComponent> {	
	private ValueEnvironment valueEnvironment;

	private ComponentCreator(ValueEnvironment valueEnvironment) {
		this.valueEnvironment = valueEnvironment;
	}
	
	public static UIComponent check(Expression tree, ValueEnvironment valueEnvironment) {		
		ComponentCreator creator = new ComponentCreator(valueEnvironment);
				
		return tree.accept(creator);
	}
	
	public static UIComponent check(Statement tree, ValueEnvironment valueEnvironment) {		
		ComponentCreator creator = new ComponentCreator(valueEnvironment);
				
		return tree.accept(creator);
	}
	
	@Override
	public UIComponent visit(Identifier identifier) {
		return new Section();
	}
	
	@Override
	public UIComponent visit(QLBoolean booleanNode) {
		return new RadioButton();
	}
	
	@Override
	public UIComponent visit(QLFloat floatNode) {
		return new FloatSpinbox();
	}
	
	@Override
	public UIComponent visit(QLInteger integerNode) {
		return new IntegerSpinbox();
	}
	
	@Override
	public UIComponent visit(QLString integerNode) {
		return new TextField();
	}
	
	@Override
	public UIComponent visit(BooleanLiteral booleanLiteral) {
		return new RadioButton(booleanLiteral.getValue());
	}
	
	@Override
	public UIComponent visit(FloatLiteral floatLiteral) {
		return new FloatSpinbox(floatLiteral.getValue());
	}
	
	@Override
	public UIComponent visit(IntegerLiteral integerLiteral) {
		return new IntegerSpinbox(integerLiteral.getValue());
	}
	
	@Override
	public UIComponent visit(StringLiteral stringNode) {
		return new Label(stringNode.getValue());
	}
	
	/**
	 * Statements
	 */	
	@Override
	public UIComponent visit(Block blockNode) {
		Section widgetPanel = new Section();
		UIComponent statementWidget;
		
		for(Statement statement : blockNode.statements()) {
			statementWidget = statement.accept(this);			
			widgetPanel.addComponent(statementWidget);
		}
		
		return widgetPanel;
	}
	
	@Override
	public UIComponent visit(ComputedQuestion compQuestionNode) {
    	UIComponent questionText = compQuestionNode.getText().accept(this);
    	InputWidget<?> questionWidget = (InputWidget<?>) compQuestionNode.getType().accept(this);
    	
    	return new UIComputedQuestion(compQuestionNode.getIdentifier(), questionText, 
    			questionWidget, compQuestionNode.getExpression(), valueEnvironment);
	}
	
	@Override
	public UIComponent visit(Question questionNode) {
		UIComponent questionText = questionNode.getText().accept(this);
    	UIComponent questionWidget = questionNode.getType().accept(this);
    	
    	return new UIQuestion(questionNode.getIdentifier(), questionText, questionWidget, valueEnvironment);
	}
	
	@Override
	public UIComponent visit(Form formNode) {
		Section formSection = new Section();
		formSection.addComponent(formNode.getBlock().accept(this));
		
		return formSection;
	}
	
	@Override
	public UIComponent visit(If ifNode) {
		return new UIConditional(ifNode.getExpression(), valueEnvironment, (Section) ifNode.getBlock().accept(this));
	}

	@Override
	public UIComponent visit(IfElse ifElseNode) {		
		Section elsePanel = (Section) ifElseNode.getElseBranch().accept(this);
		Section ifPanel = (Section) ifElseNode.getIfBranch().accept(this);
		
		return new UIConditional(ifElseNode.getExpression(), valueEnvironment, ifPanel, elsePanel);
	}
}
