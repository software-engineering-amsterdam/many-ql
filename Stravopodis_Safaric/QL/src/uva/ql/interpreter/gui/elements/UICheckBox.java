package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.Observer;
import javax.swing.JCheckBox;
import uva.ql.ast.expressions.tablevisitor.ValueTable;
import uva.ql.ast.statements.Question;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.GenericValue;

public class UICheckBox extends UIQuestion{
	
	private JCheckBox checkBox;
	
	public UICheckBox(Question question, ValueTable valueTable, Observer observer) {
		super(question, valueTable, observer);
		this.setCheckBox();
	}
	
	private void setCheckBox(){
		this.checkBox = new JCheckBox();
		this.checkBox.setText("yes");	
		this.checkBox.setSelected(this.isSelected());
		this.checkBox.addItemListener(event -> checkBoxSelected(event));
	}
	
	public Component getWidget(){
		return this.checkBox;
	}
	
	private void checkBoxSelected(ItemEvent e){
		this.updateValue(new BooleanValue((e.getStateChange() - 1) == 0));
	}
	
	private boolean isSelected(){
		GenericValue<?> value = this.getQuestionValue();
		return (boolean)value.getValue();
	}

}
