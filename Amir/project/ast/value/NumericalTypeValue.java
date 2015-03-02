package project.ast.value;

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
	
	@Override
	public boolean isType(NumericalTypeValue type){
		return true;
	}
	
	@Override
	public boolean isType(TypeValue type){
		return this.isType(type);
	}
	
    @Override
    public boolean equals(TypeValue type)
    {
    	if (type instanceof NumericalTypeValue){
    		System.out.println(this);
    	}
        return type instanceof NumericalTypeValue;
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

	@Override
	public String typeName(){
		return "numerical";
	}
}
