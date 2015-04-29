package org.nlamah.QL.Model.Form.Abstract;

import org.nlamah.QL.Interfaces.QLVisitable;

public abstract class QLNode implements QLVisitable
{	
	private QLNode parentNode;
	
	public int startsOnLine;
	public int startsAtCharacterPosition;
	public String nodeString;
	public int endsOnLine;

	public QLNode parentNode()
	{
		return this.parentNode;
	}
	
	public void setParentNode(QLNode parentElement)
	{
		this.parentNode = parentElement;
	}
}
