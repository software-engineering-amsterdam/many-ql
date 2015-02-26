package gui.widgets;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.type.Type;

public class TextFieldWidget implements IWidgetComponent  {
	private final String id, label;
	private final Type variableType;
	private JComponent widget;
		
	public TextFieldWidget(String id, String label, Type variableType) {
		this.id = id;
		this.label = label;
		this.variableType = variableType;
	}
	
	@Override
	public JComponent getWidget() {
		widget = new JTextField(10);
		widget.setVisible(visibility());
		return widget;
	}
	@Override
	public String getIdWidget() {
		return id;
	}
	@Override
	public Type getWidgetType(){
		return variableType;
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
}
