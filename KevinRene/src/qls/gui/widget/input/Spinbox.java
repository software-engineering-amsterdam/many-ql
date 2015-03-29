package qls.gui.widget.input;

import javax.swing.SpinnerNumberModel;

import ql.Value;
import qls.gui.widget.InputWidget;
import qls.gui.widget.WidgetStylizer;

public abstract class Spinbox<T extends Value> extends
		ql.gui.widget.input.Spinbox<T> implements InputWidget<T> {
	protected WidgetStylizer stylizer;

	public Spinbox(SpinnerNumberModel model) {
		super(model);

		stylizer = new WidgetStylizer();
	}
}
