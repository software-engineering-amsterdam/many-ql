package org.nlamah.QBase;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class QBaseHelper 
{
	static public String getSourceCode(String fileName) throws FileReadException
    {
		String qlSourceCode = "";
		
		try 
		{
			InputStream fileInputStream = QBaseHelper.class.getResourceAsStream(fileName);
			qlSourceCode = IOUtils.toString(fileInputStream, "UTF-8");
		} 
		catch (Exception e) 
		{	
			List<QBaseError> errors = new ArrayList<QBaseError>();
			
			throw new FileReadException(null, errors);
		}
		
		return qlSourceCode;
    }
	
	static public String removeSurroundingQuotes(String string) 
	{
		return string.substring(1, string.length() - 1);
	}
}
