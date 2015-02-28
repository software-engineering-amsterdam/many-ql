package gui.widgets;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.type.Type;


public class TextFieldWidget implements IWidgetComponent {
	private final String id, label;
	private final Type variableType;
	private JTextField widget;
	private String value;
		
	public TextFieldWidget(String id, String label, Type variableType) {
		this.id = id;
		this.label = label;
		this.variableType = variableType;
		this.widget = new JTextField("", 10);
		this.widget.setVisible(visibility());
		this.widget.getDocument().addDocumentListener(new TextDigitsListener(this, getValue()));
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
	public String getLabel() {
		return label;
	}
	@Override
	public boolean visibility() {
		return true;
		//temporary...
	}

	//@Override
	public void addDocListener() {
		widget.getDocument().addDocumentListener(new TextDigitsListener(this, getValue()));
	}

	@Override
	public String getValue() {
		value = "" + widget.getText();
		//System.out.println("cry" +value);
		
		return  value;	
		
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		widget.setText(value);
	}
}
