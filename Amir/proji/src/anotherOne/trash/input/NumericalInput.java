package anotherOne.gui.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import anotherOne.ast.question.ValueStorage;
import anotherOne.ast.value.BooleanTypeValue;
import anotherOne.ast.value.NumericalTypeValue;

public class NumericalInput extends JTextField implements Input {

	String id;
	JLabel label;
	public JTextField textField = new JTextField();
	ValueStorage values;

	public NumericalInput (String id, ValueStorage values){
		this.id = id;
		label = new JLabel(id);
		//		this.label = label;
		this.values = values;		
	}

	int input = Integer.parseInt(this.getText());

	public void addListener (){
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				values._values.put(id, new NumericalTypeValue(input));
			}
		});
	}

}
