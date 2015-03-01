package gui.widgets;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ast.type.Type;

public class ChoiceWidget implements IWidgetComponent {
	private final String id, label;
	private final Type widgetType;
	private JCheckBox widget = new JCheckBox("Yes");;
	private String value = new String("");
		
	public ChoiceWidget(String id, String label, Type widgetType) {
		this.id = id;
		this.label = label;
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
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	@Override
	public boolean visibility() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void addDocListener() {
		this.widget.addItemListener(new ChoiceListener());
		
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setValue(String value) {
		// only for textfield
		
	}

	@Override
	public boolean getChoiceValue() {
		return widget.isSelected();
	}

	@Override
	public void setChoiceValue(boolean value) {
		widget.setSelected(value);
		
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		widget.setEnabled(isEnabled);
		
	}

}
