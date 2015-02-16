package anotherOne.gui.input;

import javax.swing.JLabel;
import javax.swing.JTextField;

import anotherOne.ast.expression.Expression;
import anotherOne.ast.question.ValueStorage;

public class ConditionalBoolean extends BooleanWidget{
	
	boolean bool;
	Expression expr;
	public ConditionalBoolean(String id, ValueStorage values, Expression expr) {
		super(id, values);
		this.expr = expr; 
		// TODO Auto-generated constructor stub
		
	}

	JLabel label = new JLabel(id);
	JTextField textBox = new JTextField();
	public void activate (){
		bool = expr.accept(EXPRESSION_EVALUATION_VISITOR);
		this.setVisible(bool);
	}
	
}
