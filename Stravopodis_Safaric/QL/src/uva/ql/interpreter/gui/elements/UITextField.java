package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observer;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import uva.ql.ast.expressions.tablevisitor.ValueTable;
import uva.ql.ast.statements.Question;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.value.StringValue;

public class UITextField extends UIQuestion{
	
	private JTextField textField;
	
	public UITextField(Question question, ValueTable valueTable, Observer observer) {
		super(question, valueTable, observer);
		this.setTextField();
	}
	
	private void setTextField(){
		this.textField = new JTextField();
		this.textField.setText(this.getFieldText());

		this.textField.setColumns(10);
		this.textField.setSelectionStart(0);
		this.textField.setSelectionEnd(0);
		this.textField.setEnabled(this.shouldBeEnabled());
		
		this.setDocumentListener();
		this.setFocusListener();
	}
	
	public String getTextFieldText() {
		return this.textField.getText();
	}

	private void setDocumentListener(){
		this.textField.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				setValue(getTextFieldText());
			}

			public void removeUpdate(DocumentEvent e) {
				setValue(getTextFieldText());
			}

			public void changedUpdate(DocumentEvent e) {
				setValue(getTextFieldText());
			}
		});
	}
	
	private void setFocusListener(){
        this.textField.addFocusListener(new FocusListener() {
        	
			@Override
			public void focusGained(FocusEvent e) {
				textField.setSelectionEnd(0);
				textField.setSelectionStart(getValueLenght());
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
        });
	}
	
	public Component getWidget(){
		return this.textField;
	}
	
	private void setValue(String _value){
		
		GenericValue<?> value = this.getQuestionValue();
		GenericValue<?> updateValue;
		
		if (_value.length() != 0){
			if (value.getValueType().equals(new TypeString())){
				updateValue = new StringValue(_value);
			}
			else {
				updateValue = new NumberValue(Integer.valueOf(_value));
			}
			
			this.updateValue(updateValue);
		}
	}
	
	private GenericValue<?> getValue(){
		return super.getQuestionValue();
	}
	
	private String getFieldText(){
		String value = this.getValue().getValue().toString();
		
		if (value.equals("0")){
			return "";
		}
		return value;
	}
	
	private int getValueLenght(){
		return this.getValue().toString().length();
	}
	
	private boolean shouldBeEnabled(){
		return true;
	}
}
