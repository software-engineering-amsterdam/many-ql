package anotherOne.ast.value;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class NumericalTypeValue extends TypeValue{
	int value;
	public JTextField widget;

	public NumericalTypeValue(int value){ // amir extend to deci etc
	this.value = value;
	this.widget = new JTextField(10);
	}
	
	public NumericalTypeValue(){ // amir extend to deci etc
	this.widget = new JTextField(20);
	}
	
	public boolean biggerThan(){ // throw away??
		return (Boolean) null;
	}

//	@Override
	public int getValue() {
		return value;
	}

//	@Override
	public void setValue(int _value) {
		this.value = _value;
	}
	
	@Override
	public JComponent getWidget() {
		return this.widget;
	}

}
