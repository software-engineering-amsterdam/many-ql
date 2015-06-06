package org.nlamah.QBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.commons.io.IOUtils;
import org.nlamah.QBase.Error.QBaseError;

public class QBaseHelper 
{
	public static String qlSourceCodePath(String[] args)
	{
		String qlSourceCodePath = Constants.defaultUriSourceQL();

		if (args.length > 0)
		{
			qlSourceCodePath = Constants.baseUri()  + args[0];
		}

		return qlSourceCodePath;
	}

	public static String qlsSourceCodePath(String[] args)
	{
		String qlsSourceCodePath = Constants.defaultUriSourceQLS();

		if (args.length > 1)
		{
			qlsSourceCodePath = Constants.baseUri() + args[1];
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
		return uriForFolderAndFileNameAndLanguage(Constants.defaultUriSourceQLTestRoot(), folder, fileName, Language.QL);
	}
	
	static public String qlsUriTestForFolderAndFileName(String folder, String fileName)
	{
		return uriForFolderAndFileNameAndLanguage(Constants.defaultUriSourceQLSTestRoot(), folder, fileName, Language.QLS);
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

	static public String removeSurroundingQuotes(String string) 
	{
		return string.substring(1, string.length() - 1);
	}

	static public boolean arrayExistsAndHasElements(List<?> List)
	{
		return List != null && List.size() > 0;
	}

	static public <T> Set<T> getSetWithDuplicatedObjects(List<T> questions, QBaseEqualityState state)
	{
		for (T question : questions)
		{
			if(EqualityStating.class.isAssignableFrom(question.getClass()))
			{
				((EqualityStating) question).push(state);
			}
		}

		final Set<T> setToReturn = new HashSet<T>();
		final Set<T> set = new HashSet<T>();

		for (T node : questions) 
		{
			if (!set.add(node)) 
			{
				setToReturn.add(node);
			}
		}

		for (T question : questions)
		{
			if(EqualityStating.class.isAssignableFrom(question.getClass()))
			{
				((EqualityStating) question).popState();
			}
		}

		return setToReturn;
	}

	static public void addSourceCodePosition(QBaseNode node, ParserRuleContext ctx)
	{
		node.startsOnLine = ctx.getStart().getLine();
		node.startsAtCharacterPosition = ctx.getStart().getCharPositionInLine();
		node.nodeString = ctx.getStart().getText();
		node.endsOnLine = ctx.getStop().getLine();
	}
}