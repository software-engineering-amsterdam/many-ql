package org.nlamah.QBase;

public class Constants 
{
	static public String baseUri()
	{
		return System.getProperty("user.dir");
	}
	
	static public String defaultUriSourceQL()
	{
		return baseUri() + "/target/classes/org/nlamah/QL/source.ql";
	}
	
	static public String defaultUriSourceQLS()
	{
		return baseUri() + "/target/classes/org/nlamah/QLS/stylesheet.qls";
	}
	
	static public String defaultUriSourceQLTestRoot()
	{
		return baseUri() + "/target/classes/org/nlamah/QL/test/";
	}
	
	static public String defaultUriSourceQLSTestRoot()
	{
		return baseUri() + "/target/classes/org/nlamah/QLS/test/";
	}
}
