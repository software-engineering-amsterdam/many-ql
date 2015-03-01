package project.ast.value;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class StringTypeValue extends TypeValue {

	String str;
	public JTextField widget;

	public StringTypeValue (String value){
		this.str = value;	
		this.widget = new JTextField();
		}
	
//	@Override
	public String getValue() {
		return str;
	}

	@Override
	public boolean isType(BooleanTypeValue type){
		return true;
	}
	
	@Override
	public boolean isType(TypeValue type){
		return this.isType(type);
	}
	
    @Override
    public boolean equals(TypeValue type)
    {
    	if (type instanceof StringTypeValue){
    		System.out.println(this);
    	}
    	return type instanceof StringTypeValue;
    }

	@Override
	public JComponent getWidget() {
		return this.widget;
	}

	@Override
	public String typeName(){
		return "string";
	}
}
