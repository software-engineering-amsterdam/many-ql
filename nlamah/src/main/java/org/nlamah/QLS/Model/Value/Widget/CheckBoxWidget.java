package org.nlamah.QLS.Model.Value.Widget;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.WidgetStyle;

public class CheckBoxWidget extends WidgetStyle 
{
	public CheckBoxWidget()
	{
		super(QBaseQuestionType.BOOLEAN);
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

		if (!(object instanceof CheckBoxWidget))
		{
			return false;
		}

		return true;
	}
}
