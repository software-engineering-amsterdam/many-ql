package anotherOne.ast.value;

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
	public JComponent getWidget() {
		return this.widget;
	}

}
