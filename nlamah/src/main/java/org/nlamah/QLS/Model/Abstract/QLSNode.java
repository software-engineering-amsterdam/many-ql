package org.nlamah.QLS.Model.Abstract;

import org.nlamah.QBase.QBaseNode;
import org.nlamah.QLS.Interfaces.QLSVisitable;

public abstract class QLSNode extends QBaseNode implements QLSVisitable
{
	private QLSNode parentNode;
	
	public QLSNode parentNode()
	{
		return this.parentNode;
	}

	public void setParentNode(QLSNode parentElement)
	{
		this.parentNode = parentElement;
	}
}
