package gui.widgets;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ast.type.Type;
import evaluator.StringValue;
import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.listeners.EvaluateExpression;


public class TextFieldWidget implements IWidgetComponent {
	private final String id; 
	private final Type variableType;
	private JTextField widget;
	private final ValueRepository valueRepository;
		
	public TextFieldWidget(String id, String label, Type variableType, ValueRepository valueRepository) {
		this.id = id;
		this.variableType = variableType;
		this.valueRepository = valueRepository;
		this.widget = new JTextField("", 10);
	}
	
	@Override
	public JComponent getWidget() {
		return this.widget;
	}
		
	@Override
	public String getIdWidget() {
		return this.id;
	}
	@Override
	public Type getWidgetType(){
		return this.variableType;
	}
	
	@Override
	public Value getValue() {
		return new StringValue(widget.getText());
	}
	
	@Override
	public void setValue(Value value) {
		value = valueRepository.getValue(id); 
		widget.setText("" + value.toString());
	}
	
	@Override
	public void setEnabled(boolean isEnabled) {
		this.widget.setEnabled(isEnabled);	
	}
	
	@Override
	public void addDocListener(final EvaluateExpression evaluator) {
		//widget.getDocument().addDocumentListener(new TextListener(this, evaluator));
		widget.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {
				evaluator.setValue(getIdWidget().toString(), getValue());
			}

			public void insertUpdate(DocumentEvent arg0) {
				evaluator.setValue(getIdWidget().toString(), getValue());
			}
			
			public void removeUpdate(DocumentEvent arg0) {
				evaluator.setValue(getIdWidget().toString(), getValue());
			}
		});
	}	


	@Override
	public void setVisible(boolean visibility) {
		widget.setVisible(visibility);
	}
}