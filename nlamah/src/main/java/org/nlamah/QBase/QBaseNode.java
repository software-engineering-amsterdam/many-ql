package org.nlamah.QBase;


public abstract class QBaseNode implements Visitable
{
private QBaseNode parentNode;
	
	public int startsOnLine;
	public int startsAtCharacterPosition;
	public String nodeString;
	public int endsOnLine;
	
	public QBaseNode()
	{
		super();
	}
	
	public QBaseNode parentNode()
	{
		return this.parentNode;
	}
	
	public void setParentNode(QBaseNode parentElement)
	{
		this.parentNode = parentElement;
	}
}
