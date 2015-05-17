package org.nlamah.QL.Model.Form.Abstract;

import org.nlamah.QBase.QBaseNode;
import org.nlamah.QL.Interfaces.QLVisitable;

public abstract class QLNode extends QBaseNode implements QLVisitable
{	
	private QLNode parentNode;
	
	public QLNode parentNode()
	{
		return this.parentNode;
	}

	public void setParentNode(QLNode parentElement)
	{
		this.parentNode = parentElement;
	}
}
