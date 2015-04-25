package org.nlamah.QBase;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.nlamah.QL.QLInterpreter;

public class QBaseHelper 
{
	static public String getSourceCode(String fileName) throws FileReadException
    {
		String qlSourceCode = "";
		
		try 
		{
			InputStream fileInputStream = QLInterpreter.class.getResourceAsStream(fileName);
			qlSourceCode = IOUtils.toString(fileInputStream, "UTF-8");
		} 
		catch (Exception e) 
		{	
			ArrayList<QBaseError> errors = new ArrayList<QBaseError>();
			
			throw new FileReadException(null, errors);
		}
		
		return qlSourceCode;
    }
}
