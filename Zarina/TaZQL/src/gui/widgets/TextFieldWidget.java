package gui.widgets;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.type.Type;

public class TextFieldWidget /*extends JTextField*/ implements IWidgetComponent  {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private String id, label;
	private Type variableType;
	private final JComponent widget;
	
	
	public TextFieldWidget(String id, String label, Type variableType){
		this.id = id;
		this.label = label;
		this.variableType = variableType;
		this.widget = new JTextField(10);
	}
	
	
	@Override
	public JComponent getWidget() {
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
