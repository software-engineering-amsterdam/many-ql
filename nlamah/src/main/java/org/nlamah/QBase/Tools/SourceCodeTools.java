package org.nlamah.QBase.Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.nlamah.QBase.FileReadException;
import org.nlamah.QBase.Language;
import org.nlamah.QBase.Constants.UriConstants;
import org.nlamah.QBase.Error.QBaseError;

public class SourceCodeTools 
{
	public static String qlSourceCodePath(String[] args)
	{
		String qlSourceCodePath = UriConstants.defaultUriSourceQL();

		if (args.length > 0)
		{
			qlSourceCodePath = UriConstants.baseUri()  + args[0];
		}

		return qlSourceCodePath;
	}

	public static String qlsSourceCodePath(String[] args)
	{
		String qlsSourceCodePath = UriConstants.defaultUriSourceQLS();

		if (args.length > 1)
		{
			qlsSourceCodePath = UriConstants.baseUri() + args[1];
		}

		return qlsSourceCodePath;
	}
	
	static public String sourceCode(String resourcePath) throws FileReadException
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

			throw new FileReadException(errors);
		}
	}
	
	static public String qlSourceCodeTestForFolderAndFileName(String folder, String fileName) throws FileReadException
	{
		return sourceCode(qlUriTestForFolderAndFileName(folder, fileName));
	}
	
	static public String qlsSourceCodeTestForFolderAndFileName(String folder, String fileName) throws FileReadException
	{
		return sourceCode(qlsUriTestForFolderAndFileName(folder, fileName));
	}
	
	static public String qlUriTestForFolderAndFileName(String folder, String fileName)
	{
		return uriForFolderAndFileNameAndLanguage(UriConstants.defaultUriSourceQLTestRoot(), folder, fileName, Language.QL);
	}
	
	static public String qlsUriTestForFolderAndFileName(String folder, String fileName)
	{
		return uriForFolderAndFileNameAndLanguage(UriConstants.defaultUriSourceQLSTestRoot(), folder, fileName, Language.QLS);
	}
	
	static public String qlUriForFolderAndFileName(String root, String folder, String fileName)
	{
		return uriForFolderAndFileNameAndLanguage(root, folder, fileName, Language.QL);
	}
	
	static public String qlsUriForFolderAndFileName(String root, String folder, String fileName)
	{
		return uriForFolderAndFileNameAndLanguage(root, folder, fileName, Language.QLS);
	}
	
	static private String uriForFolderAndFileNameAndLanguage(String root, String folder, String fileName, Language language)
	{
		String result = root + folder + "/" + fileName;
		
		switch (language)
		{
		case QL:
		{
			return result + ".ql";
		}
		case QLS:
		{
			return result + ".qls";
		}
		}
		
		assert(false);
		
		return result;
	}
}