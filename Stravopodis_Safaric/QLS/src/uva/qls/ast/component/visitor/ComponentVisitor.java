package uva.qls.ast.component.visitor;

import uva.qls.ast.component.*;

public interface ComponentVisitor <T>{
	
	public T visitCheckBox(Checkbox checkBox);
	public T visitDropDown(Dropdown dropDown);
	public T visitRadio(Radio radio);
	public T visitSlider(Slider slider);
	public T visitSpinbox(Spinbox spinbox);
	public T visitTextbox(Textbox textbox);
	
}
