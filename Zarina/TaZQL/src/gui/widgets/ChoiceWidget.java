package gui.widgets;

import interpreter.ValueRepository;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ast.type.Type;

public class ChoiceWidget implements IWidgetComponent {
	private final String id, label;
	private final Type widgetType;
	private JCheckBox widget = new JCheckBox("");;
	private String value = new String("");
	//private final ValueRepository valueRepository;
		
	public ChoiceWidget(String id, String label, Type widgetType) {
		this.id = id;
		this.label = label;
	//	this.valueRepository = valueRepository;
		this.widgetType = widgetType;
		this.widget.addItemListener(new ChoiceListener());
	}

	@Override
	public JComponent getWidget() {
		//widget = new JCheckBox("Yes");
		return widget;
	}

	@Override
	public String getIdWidget() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Type getWidgetType() {
		// TODO Auto-generated method stub
		return widgetType;
	}

	@Override
	public String getTextValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getChoiceValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setChoiceValue(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDocListener(ValueRepository val) {
		// TODO Auto-generated method stub
		
	}


	

}
