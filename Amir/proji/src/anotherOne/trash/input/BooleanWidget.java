package anotherOne.gui.input;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import anotherOne.ast.question.ValueStorage;
import anotherOne.ast.value.BooleanTypeValue;

public class BooleanWidget extends JCheckBox implements Input{

	String id;
	JLabel label;
//	boolean visibility;
	public JCheckBox checkBox = new JCheckBox();
	ValueStorage values;

	public BooleanWidget (String id, ValueStorage values){
		this.id = id;
		label = new JLabel(id);
		//		this.label = label;
		this.values = values;		
	}

	boolean bool = this.isSelected();

	public void addListener (){
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				values._values.put(id, new BooleanTypeValue(bool));
			}
		});
	}

}
