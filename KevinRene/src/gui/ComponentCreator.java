package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cons.ql.ast.ASTNode;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class ComponentCreator implements StatementVisitor<Void>, ExpressionVisitor<Void> {
	
	private Container pane;
	private Controller controller;
	
	private ComponentCreator(Container pane) {
		this.pane = pane;
		this.controller = new Controller();
	}
	
	public static Container check(Container pane, ASTNode tree) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		ComponentCreator creator = new ComponentCreator(pane);
		
		tree.accept(creator);
		
		return creator.pane;
	}
	
	/**
	 * Statements
	 */		
	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
		JLabel label = new JLabel(compQuestionNode.getText().toString());
    	label.setHorizontalAlignment(0);
    	label.setFont(new Font("Serif", Font.BOLD, 20));
    	this.pane.add(label);
    	
    	TextComponent comp = new TextComponent(compQuestionNode.getIdentifier(), 
    			controller, false);
    	this.pane.add(comp.getComponent());
    	
    	ComputedQuestionObserver observer = 
    			new ComputedQuestionObserver(compQuestionNode, controller, comp);
    	controller.addGlobalObserver(observer);
    	controller.putObservable(comp.getIdentifier(), comp);
    	
    	
		return null;
	}
	
	@Override
	public Void visit(If ifNode) {
//		ifNode.getExpression().accept(this);

		// TODO, request value environment
		if (true) {
			ifNode.getBlock().accept(this);
		}
		
		return null;
	}

	@Override
	public Void visit(Question questionNode) {
		addLabel(questionNode.getText().toString(), pane);
		
		TextComponent comp = new TextComponent(questionNode.getIdentifier(), controller);
    	this.pane.add(comp.getComponent());
    	
		return null;
	}
	
	private void addLabel(String text, Container pane) {
		JLabel label = new JLabel(text);
    	label.setHorizontalAlignment(0);
    	label.setFont(new Font("Serif", Font.BOLD, 20));
    	pane.add(label);
	}
}
