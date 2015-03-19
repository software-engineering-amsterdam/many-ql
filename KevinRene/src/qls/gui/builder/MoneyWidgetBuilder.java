package qls.gui.builder;

import ql.ast.QLType;
import ql.ast.type.QLMoney;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.widget.InputWidget;

public class MoneyWidgetBuilder implements WidgetBuilder {
	@Override
	public InputWidget<?> createCheckbox(StyleProperties properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputWidget<?> createDropdown(StyleProperties properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputWidget<?> createRadioButton(StyleProperties properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputWidget<?> createSlider(StyleProperties properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputWidget<?> createSpinbox(StyleProperties properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputWidget<?> createTextField(StyleProperties properties) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public QLType getBuilderType() {
		return new QLMoney();
	}
}
