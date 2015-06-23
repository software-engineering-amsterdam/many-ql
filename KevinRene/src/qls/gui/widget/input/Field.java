package qls.gui.widget.input;

import javax.swing.SwingUtilities;

import ql.Value;
import qls.gui.widget.InputWidget;
import qls.gui.widget.WidgetStylizer;

public abstract class Field<T extends Value> extends
		ql.gui.widget.input.Field<T> implements InputWidget<T> {
	protected WidgetStylizer stylizer;

	public Field(T initialValue) {
		super(initialValue);
		stylizer = new WidgetStylizer();
	}

	@Override
	public final void setValue(T newValue) {
		Runnable changeValue = new Runnable() {
			@Override
			public void run() {
				value(newValue);
				textField().setText(convertValue(value()));
			}
		};
		
		SwingUtilities.invokeLater(changeValue);
	};

	public abstract String convertValue(Value value);
}
