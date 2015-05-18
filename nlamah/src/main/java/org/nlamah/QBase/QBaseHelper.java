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