package gui;

import gui.observer.IfObserver;
import gui.widget.IntegerSpinbox;
import gui.widget.Label;
import gui.widget.Panel;
import gui.widget.RadioButton;
import gui.widget.TextField;
import gui.widget.composite.QuestionComposite;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import cons.Value;
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
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.value.BooleanValue;
import cons.value.UndefinedValue;

@SuppressWarnings("rawtypes")
public class ComponentCreator implements StatementVisitor<Widget>, ExpressionVisitor<Widget> {	
	private JPanel pane;
	private ValueEnvironment valueEnvironment;
		
	private ComponentCreator(ValueEnvironment valueEnvironment) {
		this.pane = new JPanel();
		this.pane.setLayout(new MigLayout("insets 0, hidemode 3"));
		this.valueEnvironment = valueEnvironment;
	}
	
	public static JPanel check(ASTNode tree, ValueEnvironment valueEnvironment) {		
		ComponentCreator creator = new ComponentCreator(valueEnvironment);
		creator.pane.add(tree.accept(creator).getComponent());
		
		return creator.pane;
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
		
		for(Statement statement : blockNode.statements()) {
			widgetPanel.addComponent(statement.accept(this));
		}
		
		return widgetPanel;
	}
	
	@Override
	public Widget visit(ComputedQuestion compQuestionNode) {
    	Widget questionLabel = compQuestionNode.getText().accept(this);
    	Widget questionWidget = compQuestionNode.getType().accept(this);
//    	
//    	JComponent comp = compQuestionNode.getType().accept(
//				new WidgetFactory(compQuestionNode.getIdentifier(), controller, false));
//    	pane.add(comp.getComponent(), "wrap");
//    	
//    	ComputedQuestionObserver observer = 
//    			new ComputedQuestionObserver(compQuestionNode, controller, comp);
//    	controller.addGlobalObserver(observer);
//    	controller.putObservable(comp.getIdentifier(), comp);
    	
		return new Panel();
	}
	@Override
	public Widget visit(Question questionNode) {
		Widget questionText = questionNode.getText().accept(this);
    	Widget questionWidget = questionNode.getType().accept(this);
    	
		return new QuestionComposite(questionNode.getIdentifier(), questionText, questionWidget);
	}
	
	@Override
	public Widget visit(Form formNode) {
		return formNode.getBlock().accept(this);
	}
	
	@Override
	public Widget visit(If ifNode) {
		Value expressionValue = Evaluator.check(ifNode.getExpression(), valueEnvironment);
		Widget ifPanel = new Panel();
		
		if(expressionValue instanceof UndefinedValue) {
			return ifPanel;
		}
		
		BooleanValue booleanValue = (BooleanValue) expressionValue;
		
		if(booleanValue.getValue()) {
			ifPanel = ifNode.getBlock().accept(this);
		}
				
		ifPanel.addObserver(new IfObserver(ifNode.getExpression(), valueEnvironment, ifPanel));		
		return ifPanel;
	}

	@Override
	public Widget visit(IfElse ifElseNode) {		
		Value expressionValue = Evaluator.check(ifElseNode.getExpression(), valueEnvironment);
		Widget ifPanel = new Panel();
		Widget elsePanel = ifElseNode.getElseBranch().accept(this);
		
		if(expressionValue instanceof UndefinedValue) {
			return elsePanel;
		}
		
		BooleanValue booleanValue = (BooleanValue) expressionValue;
		
		if(booleanValue.getValue()) {
			ifPanel = ifElseNode.getIfBranch().accept(this);
			ifPanel.addObserver(new IfObserver(ifElseNode.getExpression(), valueEnvironment, ifPanel));			
			return ifPanel;
		} else {
			elsePanel.addObserver(new IfObserver(ifElseNode.getExpression(), valueEnvironment, elsePanel));
			return elsePanel;
		}
	}
}
