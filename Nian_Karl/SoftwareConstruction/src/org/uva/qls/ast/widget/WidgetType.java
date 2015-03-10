package org.uva.qls.ast.widget;

import org.uva.ql.ast.Node;
import org.uva.utility.CodePosition;


public abstract class WidgetType implements Node{
	
	private final CodePosition position;
	
	public WidgetType(CodePosition position){
		this.position = position;
	}
	
	public CodePosition getPosition() {
		return position;
	}
	
}
