package org.nlamah.QLS.Interfaces;

import org.nlamah.QLS.Model.Abstract.QLSNode;

public interface QLSVisitable 
{
	public QLSNode accept(QLSNodeVisitor visitor);
}