package gui;

import gui.observer.IfObserver;
import gui.widget.IntegerSpinbox;
import gui.widget.Label;
import gui.widget.Panel;
import gui.widget.RadioButton;
import gui.widget.TextField;
import gui.widget.composite.QuestionComposite;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import cons.ql.ast.ASTNode;
import cons.ql.ast.Statement;
import cons.ql.ast.expression.literal.BooleanLiteral;
import cons.ql.ast.expression.literal.IntegerLiteral;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.statement.Block;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.IfElse;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

@SuppressWarnings("rawtypes")
public class ComponentCreator implements StatementVisitor<Widget>, ExpressionVisitor<Widget> {	
	private JPanel pane;
	private Controller controller;
		
	private ComponentCreator(Controller controller) {
		this.pane = new JPanel();
		this.pane.setLayout(new MigLayout("insets 0, hidemode 3"));
		this.controller = controller;
	}
	
	public static JPanel check(ASTNode tree, Controller controller) {		
		ComponentCreator creator = new ComponentCreator(controller);
		creator.pane.add(tree.accept(creator).getComponent());
		
		return creator.pane;
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
    	
		return null;
	}
	@Override
	public Widget visit(Question questionNode) {
		Widget questionText = questionNode.getText().accept(this);
    	Widget questionWidget = questionNode.getType().accept(this);
    	
		return new QuestionComposite(questionNode.getIdentifier(), questionText, questionWidget);
	}
	
	@Override
	public Widget visit(If ifNode) {
		Widget ifPanel = ifNode.getBlock().accept(this);
		IfObserver ifObserver = new IfObserver(ifNode.getExpression(), controller, ifPanel);
		
		controller.addGlobalObserver(ifObserver);
		
		ifPanel.setVisible(false);
		
		return new TextField();
	}

	@Override
	public Widget visit(IfElse ifElseNode) {
		JPanel ifPanel = check(ifElseNode.getIfBranch(), controller);
		JPanel elsePanel = check(ifElseNode.getElseBranch(), controller);
		IfObserver ifObserver = new IfObserver(ifElseNode.getExpression(), controller, ifPanel, elsePanel);
		
		controller.addGlobalObserver(ifObserver);		

		ifPanel.setVisible(false);
		elsePanel.setVisible(false);
		
		pane.add(ifPanel, "span");
		pane.add(elsePanel, "span");
		
		return new TextField();
	}
}
