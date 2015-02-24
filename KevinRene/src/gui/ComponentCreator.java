package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cons.ql.ast.ASTNode;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class ComponentCreator implements StatementVisitor<Void>, ExpressionVisitor<Void> {
	
	private Container pane;
	
	private ComponentCreator(Container pane) {
		this.pane = pane;
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
//	@Override
//	public Void visit(ComputedQuestion compQuestionNode) {
//		//StatementVisitor.super.visit(compQuestionNode);
//	
//		return null;
//	}
//	
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
		System.out.println("QUESTIONNODE");
		
    	addAQuestion(questionNode.getText().toString(), this.pane);
    	
		return null;
	}
	
	
	private void addAQuestion(String text, Container container) {
    	JLabel label = new JLabel(text);
    	label.setHorizontalAlignment(0);
    	label.setFont(new Font("Serif", Font.BOLD, 20));
    	container.add(label);
    	
    	JTextField textField = new JTextField(100);
    	textField.setMaximumSize(
    			new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));
    	container.add(textField);
    }
}
