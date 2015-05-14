package org.nlamah.QLS.Model.Value.Widget;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.WidgetStyle;

public class SpinBoxWidget extends WidgetStyle 
{
	public SpinBoxWidget() 
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
		 
		 if (!(object instanceof SpinBoxWidget))
		 {
			 return false;
		 }

		 return true;
	 }
}
