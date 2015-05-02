package org.nlamah.QLS.Model.Value.Widget;

import java.util.Iterator;
import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.WidgetType;
import org.nlamah.QLS.Model.Value.TextValue;

public class RadioButtonWidgetType extends WidgetType 
{
	private List<TextValue> values;
	
	public RadioButtonWidgetType(List<TextValue> values)
	{
		super();
		
		this.values = values;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		String returnValue = "";
	
		for (Iterator<TextValue> i = values.iterator(); i.hasNext(); ) 
		{
			returnValue += i.toString();
			
			if (i.hasNext())
			{
				returnValue += ", ";
			}
		}
		
		return returnValue;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		{
			return false;
		}
		 
		 if (!(object instanceof RadioButtonWidgetType))
		 {
			 return false;
		 }
		 
		 RadioButtonWidgetType widgetType = (RadioButtonWidgetType) object;
		 
		 if (!(values.equals(widgetType.values)))
		 {
			 return false;
		 }

		 return true;
	 }
}
