package org.nlamah.QBase.Tools;

public class StringTools 
{
	static public String removeSurroundingQuotes(String string) 
	{
		return string.substring(1, string.length() - 1);
	}
	
	static public String surroundStringWithHtmlTags(String string)
	{
		return "<html>" + string + "</html>";
	}
}
