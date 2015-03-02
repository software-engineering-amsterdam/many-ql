package gui;

import gui.widgets.Widget;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import cons.ValueEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.IfElse;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class ComponentCreator implements StatementVisitor<Void>, ExpressionVisitor<Void> {
	
	private JPanel pane;
	private WidgetEnvironment controller;
	private ValueEnvironment valueEnv;
		
	private ComponentCreator(WidgetEnvironment controller, ValueEnvironment valueEnv) {
		this.pane = new JPanel();
		this.pane.setLayout(new MigLayout("insets 0, hidemode 3"));
		this.controller = controller;
		this.valueEnv = valueEnv;
	}
	
	public static JPanel check(ASTNode tree, WidgetEnvironment controller, ValueEnvironment valueEnv) {
		
		ComponentCreator creator = new ComponentCreator(controller, valueEnv);
		
		tree.accept(creator);
		
		return creator.pane;
	}
	
	/**
	 * Statements
	 */		
	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
    	addLabel(compQuestionNode.getText().toString(), pane);

    	Widget comp = compQuestionNode.getType().accept(
				new WidgetFactory(compQuestionNode.getIdentifier(), valueEnv, false));
    	pane.add(comp.getComponent(), "wrap");
    	
    	ComputedQuestionObserver observer = 
    			new ComputedQuestionObserver(compQuestionNode, valueEnv, comp);
    	controller.addGlobalObserver(observer);
    	controller.putObservable(comp.getIdentifier(), comp);
    	
		return null;
	}
	@Override
	public Void visit(Question questionNode) {
		addLabel(questionNode.getText().toString(), pane);
		
		Widget comp = questionNode.getType().accept(
				new WidgetFactory(questionNode.getIdentifier(), valueEnv));
		
		controller.putObservable(questionNode.getIdentifier(), comp);
	    pane.add(comp.getComponent(), "wrap");
    	
		return null;
	}
	
	@Override
	public Void visit(If ifNode) {
		JPanel ifPanel = check(ifNode.getBlock(), controller, valueEnv);
		IfObserver ifObserver = new IfObserver(ifNode.getExpression(), valueEnv, ifPanel);
		
		controller.addGlobalObserver(ifObserver);
		
		ifPanel.setVisible(false);
		
		pane.add(ifPanel, "span");
		
		return null;
	}

	@Override
	public Void visit(IfElse ifElseNode) {
		JPanel ifPanel = check(ifElseNode.getIfBranch(), controller, valueEnv);
		JPanel elsePanel = check(ifElseNode.getElseBranch(), controller, valueEnv);
		IfObserver ifObserver = new IfObserver(ifElseNode.getExpression(), valueEnv, ifPanel, elsePanel);
		
		controller.addGlobalObserver(ifObserver);		

		ifPanel.setVisible(false);
		elsePanel.setVisible(false);
		
		pane.add(ifPanel, "span");
		pane.add(elsePanel, "span");
		
		return null;
	}
	
	private void addLabel(String text, Container pane) {
		JLabel label = new JLabel(text);
    	label.setFont(new Font("Serif", Font.BOLD, 20));
    	pane.add(label, "wrap");
	}

}
