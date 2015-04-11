package org.nlamah.QL.Helper;

import java.util.ArrayList;

public class Helper 
{
	static public boolean arrayExistsAndHasElements(ArrayList<?> arrayList)
	{
		return arrayList != null && arrayList.size() > 0;
	}
	
	static public int contentWidth()
	{
		return 600;
	}
}


