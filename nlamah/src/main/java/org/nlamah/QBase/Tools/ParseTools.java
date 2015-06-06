package org.nlamah.QBase.Tools;

import org.antlr.v4.runtime.ParserRuleContext;
import org.nlamah.QBase.QBaseNode;

public class ParseTools 
{
	static public void addSourceCodePosition(QBaseNode node, ParserRuleContext ctx)
	{
		node.startsOnLine = ctx.getStart().getLine();
		node.startsAtCharacterPosition = ctx.getStart().getCharPositionInLine();
		node.nodeString = ctx.getStart().getText();
		node.endsOnLine = ctx.getStop().getLine();
	}
}
