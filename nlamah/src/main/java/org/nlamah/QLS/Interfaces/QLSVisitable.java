package org.nlamah.QLS.Interfaces;

import org.nlamah.QLS.Model.QLSNode;

public interface QLSVisitable 
{
	public QLSNode accept(QLSNodeVisitor visitor);
}
