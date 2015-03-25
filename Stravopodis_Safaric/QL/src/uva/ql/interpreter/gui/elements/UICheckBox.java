package uva.ql.interpreter.gui.elements;

import java.awt.event.ItemEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JCheckBox;
import uva.ql.ast.statements.Question;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.GenericValue;
import uva.ql.interpreter.gui.supporting.UpdateValue;

public class UICheckBox extends Observable implements UIWidgetKit{
	
	private GenericValue<?> value;
	private Observer observer;
	private Question question;
	
	public UICheckBox(Question question, GenericValue<?> value, Observer observer) {		
		this.addObserver(observer);
		this.observer = observer;
		this.question = question;
		this.value = value;
	}
	
	@Override
	public JCheckBox rander() {
		JCheckBox checkBox = new JCheckBox();
		
		checkBox = new JCheckBox();
		checkBox.setText("yes");	
		checkBox.setSelected(this.isEnabled());
		checkBox.addItemListener(event -> checkBoxSelected(event));
		
		return checkBox;
	}
	
	private void checkBoxSelected(ItemEvent e){
		BooleanValue updateValue = new BooleanValue((e.getStateChange() - 1) == 0);
		this.observer.update(this, new UpdateValue(this.question.getQuestionIdentifier(), updateValue));
	}

	@Override
	public boolean isEnabled() {
		GenericValue<?> value = this.value;
		return (boolean)value.getValue();
	}
}
