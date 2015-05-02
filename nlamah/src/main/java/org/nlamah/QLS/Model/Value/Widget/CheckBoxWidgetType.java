package org.nlamah.QLS.Model.Value.Widget;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.WidgetType;

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
