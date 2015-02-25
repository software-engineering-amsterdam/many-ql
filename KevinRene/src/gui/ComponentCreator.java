package gui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import cons.ValueEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class ComponentCreator implements StatementVisitor<Void>, ExpressionVisitor<Void> {
	
	private Container pane;
	private Controller controller;
	
	private ComponentCreator(Container pane, ValueEnvironment valueEnv) {
		this.pane = pane;
		this.controller = new Controller(valueEnv);
	}
	
	public static Container check(Container pane, ASTNode tree, ValueEnvironment valueEnv) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		ComponentCreator creator = new ComponentCreator(pane, valueEnv);
		
		tree.accept(creator);
		
		return creator.pane;
	}
	
	/**
	 * Statements
	 */		
	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
    	addLabel(compQuestionNode.getText().toString(), pane);
    	
    	TextComponent comp = new TextComponent(compQuestionNode.getIdentifier(), 
    			controller, false);
    	pane.add(comp.getComponent());
    	
    	ComputedQuestionObserver observer = 
    			new ComputedQuestionObserver(compQuestionNode, controller, comp);
    	controller.addGlobalObserver(observer);
    	controller.putComponent(comp.getIdentifier(), comp);
    	
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
		controller.putComponent(questionNode.getIdentifier(), comp);
    	pane.add(comp.getComponent());
    	
		return null;
	}
	
	private void addLabel(String text, Container pane) {
		JLabel label = new JLabel(text);
    	label.setHorizontalAlignment(0);
    	label.setFont(new Font("Serif", Font.BOLD, 20));
    	pane.add(label);
	}

}
