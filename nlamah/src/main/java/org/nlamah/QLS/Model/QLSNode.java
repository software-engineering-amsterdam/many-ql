package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSVisitable;

public abstract class QLSNode implements QLSVisitable
{
	private QLSNode parentNode;
	
	public int startsOnLine;
	public int startsAtCharacterPosition;
	public String nodeString;
	public int endsOnLine;

	public QLSNode parentNode()
	{
		return this.parentNode;
	}
	
	public void setParentNode(QLSNode parentElement)
	{
		this.parentNode = parentElement;
	}
}
