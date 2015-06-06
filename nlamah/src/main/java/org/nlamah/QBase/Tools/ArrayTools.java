package org.nlamah.QBase.Tools;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.nlamah.QBase.Constants.QBaseEqualityState;
import org.nlamah.QBase.Interfaces.EqualityStating;

public class ArrayTools 
{
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
}
