package org.nlamah.QLS.Model;

import java.util.Iterator;
import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

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
}
