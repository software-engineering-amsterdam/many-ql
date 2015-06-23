package org.nlamah.QBase.Model;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class QBaseNode
{
	public int startsOnLine;
	public int startsAtCharacterPosition;
	public String nodeString;
	public int endsOnLine;	
	
	static public void addSourceCodePosition(QBaseNode node, ParserRuleContext ctx)
	{
		node.startsOnLine = ctx.getStart().getLine();
		node.startsAtCharacterPosition = ctx.getStart().getCharPositionInLine();
		node.nodeString = ctx.getStart().getText();
		node.endsOnLine = ctx.getStop().getLine();
	}
}