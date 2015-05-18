package org.nlamah.QBase.Error;

public abstract class QBaseError 
{
	abstract public String description();
	
	@Override
	public boolean equals(Object object)
	{
		if (object == null)
		{
			return false;
		}
			
		if (this == object)
		{
			return true;
		}
		
		QBaseError value = (QBaseError) object;
		
		if (!this.description().equals(value.description()))
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode()
	{
		return description().hashCode();
	}
}