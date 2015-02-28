package gui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cons.ValueEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class ComponentCreator implements StatementVisitor<Void>, ExpressionVisitor<Void> {
	
	private JPanel pane;
	private Controller controller;
		
	private ComponentCreator(JPanel pane, ValueEnvironment valueEnv) {
		this.pane = pane;
		this.controller = new Controller(valueEnv);
	}
	
	public static JPanel check(ASTNode tree, ValueEnvironment valueEnv) {
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		ComponentCreator creator = new ComponentCreator(container, valueEnv);
		
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

		JPanel container = check(ifNode.getBlock(), controller.getValueEnvironment());
		IfObserver ifObserver = new IfObserver(ifNode, controller, container);
		
		controller.addGlobalObserver(ifObserver);
		
		pane.add(container);
		
		// TODO, request value environment
//		if (true) {
//			ifNode.getBlock().accept(this);
//		}
		
		return null;
	}

	@Override
	public Void visit(Question questionNode) {
		addLabel(questionNode.getText().toString(), pane);
		
		if (questionNode.getType() instanceof QLString) {
			TextComponent comp = new TextComponent(questionNode.getIdentifier(), controller);
			controller.putComponent(questionNode.getIdentifier(), comp);
	    	pane.add(comp.getComponent());
		}
		else if (questionNode.getType() instanceof QLInteger) {
			IntegerComponent comp = new IntegerComponent(questionNode.getIdentifier(), controller);
			controller.putComponent(questionNode.getIdentifier(), comp);
	    	pane.add(comp.getComponent());
		}
    	
		return null;
	}
	
	private void addLabel(String text, Container pane) {
		JLabel label = new JLabel(text);
    	label.setHorizontalAlignment(0);
    	label.setFont(new Font("Serif", Font.BOLD, 20));
    	pane.add(label);
	}

}
