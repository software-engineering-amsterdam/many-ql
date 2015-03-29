package qls.ast.visitor.widgetbinder;

import java.util.HashMap;
import java.util.Map;

import ql.ast.QLType;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLMoney;
import ql.ast.type.QLString;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.InputWidget;
import qls.gui.widget.input.Radio;
import qls.gui.widget.input.field.TextField;
import qls.gui.widget.input.spinbox.FloatSpinbox;
import qls.gui.widget.input.spinbox.IntegerSpinbox;
import qls.gui.widget.input.spinbox.MoneySpinbox;

public class DefaultWidgetEnvironment {
	private Map<QLType, InputWidget<?>> environment;
	private DefaultWidgetEnvironment parentEnvironment;
	
	public DefaultWidgetEnvironment() {
		environment = new HashMap<QLType, InputWidget<?>>();
		
		environment.put(new QLBoolean(), new Radio(new StringValue("Yes"), new StringValue("No")));
		environment.put(new QLFloat(), new FloatSpinbox());
		environment.put(new QLInteger(), new IntegerSpinbox());
		environment.put(new QLMoney(), new MoneySpinbox());
		environment.put(new QLString(), new TextField());
	}
	
	public DefaultWidgetEnvironment(DefaultWidgetEnvironment parent) {
		environment = new HashMap<QLType, InputWidget<?>>();
		
		parentEnvironment = parent;
	}
	
	public void store(QLType type, InputWidget<?> widgetInstance) {
		environment.put(type, widgetInstance);
	}
	
	public void storeDefaultStyle(QLType type, StyleProperties properties) {
		InputWidget<?> widget = environment.get(type);
		
		widget.setStyle(properties);
		
		environment.put(type, widget);
	}
	
	public InputWidget<?> resolve(QLType type) {
		InputWidget<?> widget = environment.get(type);
		
		if(widget == null && parentEnvironment != null) {
			widget = parentEnvironment.resolve(type);
		}
		
		return widget;
	}
	
	public DefaultWidgetEnvironment getParent() {
		if(parentEnvironment == null) {
			return this;
		}
		
		return parentEnvironment;
	}
}
