package org.nlamah.QBase.Tools;

import java.util.List;

public class ArrayTools 
{
	static public boolean arrayExistsAndHasElements(List<?> List)
	{
		return List != null && List.size() > 0;
	}
}
