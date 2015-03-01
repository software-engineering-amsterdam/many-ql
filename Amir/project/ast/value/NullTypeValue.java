package project.ast.value;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class NullTypeValue extends TypeValue{
	int value;
	public JTextField widget;

	public NullTypeValue(int value){ // amir extend to deci etc
	this.value = value;
	this.widget = new JTextField(10);
	}
	
	public NullTypeValue(){ // amir extend to deci etc
	this.widget = new JTextField(20);
	}
	
    @Override
    public boolean equals(TypeValue type)
    {
        return type instanceof NullTypeValue;
    }

	@Override
	public boolean isType(NullTypeValue type){
		return true;
	}
	
	@Override
	public boolean isType(TypeValue type){
		return this.isType(type);
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
