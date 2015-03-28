package uva.ql.interpreter.gui.elements;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import uva.ql.ast.statements.Question;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.value.StringValue;
import uva.ql.interpreter.gui.supporting.UpdateValue;

public class UITextField extends Observable implements UIWidgetKit{
	
	private GenericValue<?> value;
	private Observer observer;
	private Question question;
	
	public UITextField(Question question, GenericValue<?> value , Observer observer) {	
		this.addObserver(observer);
		this.observer = observer;
		this.question = question;
		this.value = value;
	}
	
	@Override
	public JTextField rander() {
		JTextField textField = new JTextField();
		textField.setText(this.getFieldText());

		textField.setColumns(10);
		textField.setSelectionStart(0);
		textField.setSelectionEnd(0);
		textField.setEditable(this.isEnabled());
		
		this.addDocumentListener(textField);
		this.setFocusListener(textField);
		
		return textField;
	}
	
	private String getFieldText(){
		String valueText = this.getValueForQuestion();
		
		if (valueText.equals("0")){
			return "";
		}
		else {
			return valueText;
		}
	}
	
	private String getValueForQuestion(){
		GenericValue<?> value = this.value;
		return String.valueOf(value.getValue());
	}
	
	private void setValue(String _value){
		
		GenericValue<?> updateValue;
		
		if (_value.length() != 0){
			updateValue = this.setUpdateValue(value, _value);
		}
		else {
			Type questionType = this.question.getQuestionType();
			updateValue = questionType.typeInitialValue();
		}
		
		this.observer.update(this, new UpdateValue(this.question.getQuestionIdentifier(), updateValue));
	}
	
	private GenericValue<?> setUpdateValue(GenericValue<?> value, String textFieldValue){
		
		try{
			if (value.valueHasType().equals(new TypeString())){
				return new StringValue(textFieldValue);
			}
			else {
				return new NumberValue(Integer.valueOf(textFieldValue));
			}
		}
		catch (NumberFormatException formatException){
			System.out.println("Exception: " + formatException.getMessage());
		}
		
		return null;
	}

	private void addDocumentListener(JTextField textField){
		
		textField.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				setValue(textField.getText());
			}

			public void removeUpdate(DocumentEvent e) {
				setValue(textField.getText());
			}

			public void changedUpdate(DocumentEvent e) {
				setValue(textField.getText());
			}
		});
	}
	
	private void setFocusListener(JTextField textField){
        textField.addFocusListener(new FocusListener() {
        	
			@Override
			public void focusGained(FocusEvent e) {
				textField.setSelectionEnd(0);
				textField.setSelectionStart(getValueForQuestion().length());
			}

			@Override
			public void focusLost(FocusEvent e) {}
        });
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
