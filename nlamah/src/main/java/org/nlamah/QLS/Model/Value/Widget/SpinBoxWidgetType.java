package org.nlamah.QLS.Model.Value.Widget;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.WidgetType;

public class SpinBoxWidgetType extends WidgetType 
{
	public SpinBoxWidgetType() 
	{
		super(QBaseQuestionType.NUMBER);
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		{
			return false;
		}
		 
		 if (!(object instanceof SpinBoxWidgetType))
		 {
			 return false;
		 }

		 return true;
	 }
}
