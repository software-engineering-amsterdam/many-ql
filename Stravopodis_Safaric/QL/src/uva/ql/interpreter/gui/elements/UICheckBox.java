package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observer;
import javax.swing.JCheckBox;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Question;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.GenericValue;
import uva.ql.interpreter.gui.supporting.Size;
import uva.ql.interpreter.gui.supporting.UpdateValue;

public class UICheckBox extends UIWidget {
	
	private GenericValue<?> value;
	private JCheckBox checkBox;
	private Observer observer;
	private Question question;
	
	public UICheckBox(Question question, GenericValue<?> value, Observer observer) {		
		this.addObserver(observer);
		this.observer = observer;
		this.question = question;
		this.value = value;
	}
	
	public UIContainer returnQuestionComponent(){
		this.setCheckBox();
		
		UIContainer container = new UIContainer(new Size(600,50));
		
		List <Object> components = new ArrayList<>(Arrays.asList(new UILabel(this.getQuestionLabelText()), this.checkBox));
		container.addComponents(components);
		
		return container;
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
		BooleanValue updateValue = new BooleanValue((e.getStateChange() - 1) == 0);
		this.observer.update(this, new UpdateValue(this.getQuestionIdentifier(), updateValue));
	}
	
	private boolean isSelected(){
		GenericValue<?> value = this.getValueForQuestion();
		return (boolean)value.getValue();
	}

	@Override
	public String getQuestionLabelText() {
		return this.question.getQuestionLabelText();
	}

	@Override
	public Identifier getQuestionIdentifier() {
		return this.question.getQuestionIdentifier();
	}

	@Override
	public String getQuestionIdentifierValue() {
		return this.question.getQuestionIdentifierValue();
	}

	@Override
	public GenericValue<?> getValueForQuestion() {
		return this.value;
	}
}
