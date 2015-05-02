package org.nlamah.QLS.TypeChecker;

import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Error.QLSException;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;

public class QLSTypeChecker 
{		
	public void check(Form form, QLStylesheet stylesheet) throws QLSException
	{	
		parseValuesToNativeValue(stylesheet);
		areAllTheQuestionDeclarationsInTheForm(form, stylesheet);
		areAllQuestionsFormTheFormPlace(form, stylesheet);
		areAllTheQuestionsPlacedOnlyOnce(form, stylesheet);
		areAllWidgetTypesCorrespondingCorrectlyWithTheQuestionType(form, stylesheet);
	}
	
	private boolean parseValuesToNativeValue(QLStylesheet stylesheet)
	{
		return true;
	}
	
	private boolean areAllTheQuestionDeclarationsInTheForm(Form form, QLStylesheet stylesheet)
	{
		return true;
	}
	
	private boolean areAllQuestionsFormTheFormPlace(Form form, QLStylesheet styelsheet)
	{
		return true;
	}
	
	private boolean areAllTheQuestionsPlacedOnlyOnce(Form form, QLStylesheet stylesheet)
	{
		return true;
	}
	
	private boolean areAllWidgetTypesCorrespondingCorrectlyWithTheQuestionType(Form form, QLStylesheet stylesheet)
	{
		return true;
	}	
}
