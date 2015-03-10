package org.uva.qls.ast.widget;

import org.uva.ql.ast.QLNode;
import org.uva.utility.CodePosition;


public abstract class WidgetType implements QLNode{
	
	private final CodePosition position;
	public WidgetType(CodePosition position){
		this.position = position;
	}
	
	
	
}
