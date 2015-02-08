package anotherOne.ast.value;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class BooleanTypeValue extends TypeValue {
	
	public boolean boolVal;
	public JCheckBox widget;
	//public JLabel addLabelHere;
	public BooleanTypeValue(boolean value){
		this.boolVal = value;		
		this.widget = new JCheckBox("No");
		this.widget.setSelected(false);;//.turnCheckBox.setSelected
	}

	public BooleanTypeValue(){
//		this.boolVal = value;		
		this.widget = new JCheckBox("No");
		this.widget.setSelected(false);;//.turnCheckBox.setSelected
	}
	
	public void setWidgetLabel(boolean bool){
		System.out.println("before");
		if (bool) {this.widget = new JCheckBox("Yes");}
		else {this.widget = new JCheckBox("No");}
		System.out.println("after");
	}

//	@Override
	public boolean getValue() {
		return boolVal;
	}

	@Override
	public JComponent getWidget() {
//		System.out.print("check widget");
		
		return this.widget;
	}
	
	
	
	
}
