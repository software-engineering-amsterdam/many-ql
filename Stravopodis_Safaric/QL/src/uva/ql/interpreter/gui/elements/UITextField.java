package uva.ql.interpreter.gui.elements;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observer;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Question;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.value.StringValue;
import uva.ql.interpreter.gui.supporting.Size;
import uva.ql.interpreter.gui.supporting.UpdateValue;

public class UITextField extends UIWidget{
	
	private GenericValue<?> value;
	private JTextField textField;
	private Observer observer;
	private Question question;
	
	public UITextField(Question question, GenericValue<?> value , Observer observer) {	
		this.addObserver(observer);
		this.observer = observer;
		this.question = question;
		this.value = value;
	}
	
	public UIContainer returnQuestionComponent(){
		this.setTextField();
		
		UIContainer container = new UIContainer(new Size(600,50));
		
		List <Object> components = new ArrayList<>(Arrays.asList(new UILabel(this.getQuestionLabelText()), this.textField));
		container.addComponents(components);
		
		return container;
	}
	
	private String getFieldText(){
		return this.getStringValueForQuestion();
	}
	
	private String getStringValueForQuestion(){
		GenericValue<?> value = this.getValueForQuestion();
		return String.valueOf(value.getValue());
	}
	
	private boolean shouldBeEnabled(){
		return true;
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

	private void setDocumentListener(){
		this.textField.getDocument().addDocumentListener(new DocumentListener(){
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
	
	private void setValue(String _value){
		
		GenericValue<?> value = this.getValueForQuestion();
		GenericValue<?> updateValue;
		
		if (_value.length() != 0){
			if (value.getValueType().equals(new TypeString())){
				updateValue = new StringValue(_value);
			}
			else {
				updateValue = new NumberValue(Integer.valueOf(_value));
			}

			this.observer.update(this, new UpdateValue(this.getQuestionIdentifier(), updateValue));
		}
	}
	
	private void setFocusListener(){
        this.textField.addFocusListener(new FocusListener() {
        	
			@Override
			public void focusGained(FocusEvent e) {
				textField.setSelectionEnd(0);
				textField.setSelectionStart(getStringValueForQuestion().length());
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
        });
	}
}
