package qls.gui.widget.input;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;

import ql.Value;
import ql.gui.DefaultChangeHandler;
import ql.gui.UIComponent;
import ql.gui.structure.Panel;
import ql.gui.widget.input.RadioButton;
import ql.value.BooleanValue;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.InputWidget;
import qls.gui.widget.WidgetStylizer;

public class Radio extends DefaultChangeHandler implements InputWidget<BooleanValue> {
	private WidgetStylizer stylizer;
	private RadioButton trueRadio, falseRadio;
	private ButtonGroup buttons;
	private Panel buttonsPanel;
	
	public Radio(StringValue trueValue, StringValue falseValue) {
		stylizer = new WidgetStylizer();
		
		trueRadio = new RadioButton(trueValue);
		falseRadio = new RadioButton(falseValue);
		
		buttons = new ButtonGroup();
		buttons.add((AbstractButton) trueRadio.getComponent());
		buttons.add((AbstractButton) falseRadio.getComponent());
		
		buttonsPanel = new Panel(this);
		buttonsPanel.addComponent(trueRadio);
		buttonsPanel.addComponent(falseRadio);
	}
	
	@Override
	public void disable() {
		trueRadio.disable();
		falseRadio.disable();
	}
	
	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(trueRadio.getComponent(), properties);
		stylizer.setStyle(falseRadio.getComponent(), properties);
	}
	
	@Override
	public JComponent getComponent() {
		return buttonsPanel.getComponent();
	}

	@Override
	public void setValue(BooleanValue value) {
		if(value.getValue()) {
			trueRadio.setValue(new BooleanValue(true));
		} else {
			falseRadio.setValue(new BooleanValue(true));
		}
	}

	@Override
	public BooleanValue getValue() {
		if(trueRadio.getValue().getValue()) {
			return new BooleanValue(true);
		}
		
		return new BooleanValue(false);
	}

	@Override
	public void updateComponent() {
		buttonsPanel.updateComponent();
	}
	
	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		super.handleChange(getValue(), this);
	}
}
