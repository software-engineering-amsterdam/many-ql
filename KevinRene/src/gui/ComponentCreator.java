package gui;

import gui.widgets.Widget;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import cons.ql.ast.ASTNode;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.IfElse;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class ComponentCreator implements StatementVisitor<Void>, ExpressionVisitor<Void> {
	
	private JPanel pane;
	private Controller controller;
		
	private ComponentCreator(Controller controller) {
		this.pane = new JPanel();
		this.pane.setLayout(new MigLayout("insets 0, hidemode 3"));
		this.controller = controller;
	}
	
	public static JPanel check(ASTNode tree, Controller controller) {
		
		ComponentCreator creator = new ComponentCreator(controller);
		
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
				new WidgetFactory(compQuestionNode.getIdentifier(), controller, false));
    	pane.add(comp.getComponent(), "wrap");
    	
    	ComputedQuestionObserver observer = 
    			new ComputedQuestionObserver(compQuestionNode, controller, comp);
    	controller.addGlobalObserver(observer);
    	controller.putComponent(comp.getIdentifier(), comp);
    	
		return null;
	}
	@Override
	public Void visit(Question questionNode) {
		addLabel(questionNode.getText().toString(), pane);
		
		Widget comp = questionNode.getType().accept(
				new WidgetFactory(questionNode.getIdentifier(), controller));
		
		controller.putComponent(questionNode.getIdentifier(), comp);
	    pane.add(comp.getComponent(), "wrap");
    	
		return null;
	}
	
	@Override
	public Void visit(If ifNode) {
		JPanel ifPanel = check(ifNode.getBlock(), controller);
		IfObserver ifObserver = new IfObserver(ifNode.getExpression(), controller, ifPanel);
		
		controller.addGlobalObserver(ifObserver);
		
		ifPanel.setVisible(false);
		
		pane.add(ifPanel, "span");
		
		return null;
	}

	@Override
	public Void visit(IfElse ifElseNode) {
		JPanel ifPanel = check(ifElseNode.getIfBranch(), controller);
		JPanel elsePanel = check(ifElseNode.getElseBranch(), controller);
		IfObserver ifObserver = new IfObserver(ifElseNode.getExpression(), controller, ifPanel, elsePanel);
		
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
