package anotherOne.ast.value;

import javax.swing.JComponent;

import anotherOne.ast.IGlobalElement;

public abstract class TypeValue implements IGlobalElement {

//	public abstract  Object getValue();
	
//	public abstract void setValue(<T> obj);
	
	public abstract JComponent getWidget();
}
