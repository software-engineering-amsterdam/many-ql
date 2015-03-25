package gui.widgets;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ast.type.Type;
import evaluator.IntegerValue;
import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.listeners.EvaluateExpression;

public class IntegerFieldWidget implements IWidgetComponent {

	private final String id; 
	private final Type variableType;
	private JTextField widget;
	private final ValueRepository valueRepository;
	private IntegerValue value;
			
	public IntegerFieldWidget(String id, String label, Type variableType, ValueRepository valueRepository) {
		this.id = id;
		this.variableType = variableType;
		this.valueRepository = valueRepository;
		this.widget = new JTextField(10);
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
	public Type getWidgetType() {
		return variableType;
	}
	
	@Override
	public void setValue(Value value) {
		this.value = (IntegerValue) value;
		int computation = (Integer) value.getValue();
		
		widget.setText(String.valueOf(computation));
		setDefaultBorder();
	}

	@Override
	public IntegerValue getValue() {
		String insertedValue = widget.getText().trim();
		String regexDigits ="[-+]?\\d+(\\.\\d+)?";
		
		if (!insertedValue.isEmpty() && insertedValue.matches(regexDigits)) {
			setDefaultBorder();
			return new IntegerValue(Integer.valueOf(insertedValue));
		}
		setWarningBorder();
		return new IntegerValue(0); 
	}
	
	
	@Override
	public void setEnabled(boolean isEnabled) {
		this.widget.setEnabled(isEnabled);	
	}
	
	@Override
	public void addDocListener(final EvaluateExpression evaluator) {
		//widget.getDocument().addDocumentListener(new IntegerListener(this, evaluator));
		widget.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {
				evaluator.setValue(getIdWidget().toString(), getValue());
				evaluator.setValueInGUI();
			}

			public void insertUpdate(DocumentEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						evaluator.setValue(getIdWidget().toString(), getValue());
						evaluator.setValueInGUI();
					}
				});
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
	
	private void setWarningBorder() {
		Border warningBorder = BorderFactory.createLineBorder(Color.RED, 1);
		widget.setBorder(warningBorder);
	}
	
	private void setDefaultBorder() {
		Border defaultBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
		widget.setBorder(defaultBorder);
	}
}
