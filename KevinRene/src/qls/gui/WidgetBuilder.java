package qls.gui;

import ql.gui.UIComponent;

public interface WidgetBuilder {
	public UIComponent createCheckbox();
	public UIComponent createDropdown();
	public UIComponent createRadioButton();
	public UIComponent createSlider();
	public UIComponent createSpinbox();
	public UIComponent createTextField();
}
