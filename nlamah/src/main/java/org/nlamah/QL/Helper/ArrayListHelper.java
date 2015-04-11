package org.nlamah.QL.Helper;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.FormElementViewController;
import org.nlamah.QL.FormViews.FormElementView;

public class ArrayListHelper 
{
	static public boolean arrayExistsAndHasElements(ArrayList<?> arrayList)
	{
		return arrayList != null && arrayList.size() > 0;
	}
	
	static public ArrayList<FormElementView> createViewFromViewControllers(ArrayList<FormElementViewController> formElementViewControllers)
	{
		ArrayList<FormElementView> formElementViews = new ArrayList<FormElementView>(formElementViewControllers.size());
		
		for (int i = 0; i < formElementViewControllers.size(); i++)
		{
			formElementViews.add(formElementViewControllers.get(i).view());
		}
		
		return formElementViews;
	}
}


