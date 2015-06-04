package org.nlamah.QBase;

public interface EqualityStating 
{
	public void push(QBaseEqualityState state);
	public QBaseEqualityState popState();
}