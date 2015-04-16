package qlProject.gui.input_response_visitors;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import qlProject.ast.type.BooleanType;
import qlProject.ast.type.ITypeVisitor;
import qlProject.ast.type.IntType;
import qlProject.ast.type.StringType;
import qlProject.ast.value.BoolValue;
import qlProject.ast.value.IntValue;
import qlProject.ast.value.NullValue;
import qlProject.ast.value.StringValue;
import qlProject.ast.value.Value;

public class InputTypeVisitor implements ITypeVisitor {

	private final JComponent component;

	public InputTypeVisitor(JComponent component) {
		this.component = component;
	}


	public Value visit (StringType type){
		String input = ((JTextField)component).getText();
		if (input.isEmpty()) return new NullValue();
		return new StringValue(input);
	}

	public static boolean isInteger(String s) {
		try { 
			Integer.parseInt(s);
			return true;
		} catch(NumberFormatException e) { 
			return false; 
		}
	}


	public Value visit(IntType type){
		JFormattedTextField tf = (JFormattedTextField)component;
		
		if (tf.getValue() == (null)){
			return new NullValue();
		}

		String input = ((Number)tf.getValue()).toString(); 

		if (input.isEmpty() || !isInteger(input))
			return new NullValue();
		return new IntValue(Integer.valueOf(input));
	}

	public Value visit(BooleanType type){
		boolean selected = ((JCheckBox)component).isSelected();
		return new BoolValue(selected);
	}

}