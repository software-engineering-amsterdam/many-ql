package org.nlamah.QBase.Interfaces;

import org.nlamah.QBase.Constants.QBaseEqualityState;

public interface EqualityStating 
{
	public void push(QBaseEqualityState state);
	public QBaseEqualityState popState();
}