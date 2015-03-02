package project.ast.value;

import javax.swing.JComponent;

import project.ast.IGlobalElement;

public abstract class TypeValue implements IGlobalElement {

//	public abstract  Object getValue();
	
//	public abstract void setValue(<T> obj);
	
	public abstract JComponent getWidget();
	
	public abstract String typeName();
	
	public abstract boolean isType(TypeValue type);

	public boolean isType(StringTypeValue type){
		return false;
	}

	public boolean isType(BooleanTypeValue type){
		return false;
	}
	
	public boolean isType(NumericalTypeValue type){
		return false;
	}

	public boolean isType(NullTypeValue type) {
		return false;
	}

	public abstract boolean equals(TypeValue type);	

//	public abstract boolean equals(Object type);	

}
