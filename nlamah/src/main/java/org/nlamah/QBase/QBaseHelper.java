package org.nlamah.QBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class QBaseHelper 
{
	static public String getSourceCode(String resourcePath) throws FileReadException
    {
		try 
		{
			File file = new File(resourcePath);
			
			InputStream inputStream = new FileInputStream(file);
			
			return IOUtils.toString(inputStream, "UTF-8");
		} 
		catch (Exception e) 
		{	
			e.printStackTrace();
			
			List<QBaseError> errors = new ArrayList<QBaseError>();
			
			throw new FileReadException(null, errors);
		}
    }
	
	static public String removeSurroundingQuotes(String string) 
	{
		return string.substring(1, string.length() - 1);
	}
}
