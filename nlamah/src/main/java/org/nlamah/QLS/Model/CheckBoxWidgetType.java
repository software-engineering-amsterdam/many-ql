package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class CheckBoxWidgetType extends WidgetType 
{
	public CheckBoxWidgetType()
	{
		super();
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
