package org.nlamah.QBase;

import org.nlamah.QBase.Builders.FormFactory;
import org.nlamah.QBase.Constants.Language;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Tools.SourceCodeTools;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Builders.StylesheetFactory;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

import junit.framework.TestCase;

public abstract class QBaseTestCase extends TestCase 
{
	protected Form parsedForm;
	protected Form referenceForm;
	
	protected Stylesheet parsedStylesheet;
	protected Stylesheet referenceStylesheet;
	
	protected static Form produceFormFromSourceFile(String folder, String fileName, boolean skipTypeChecking) throws QBaseException
	{		
		FormFactory formFactory = new FormFactory(Language.QL);
		
		if (skipTypeChecking)
		{
			formFactory.skipTypeChecking();
		}
		
		Form form = formFactory.form(SourceCodeTools.qlUriTestForFolderAndFileName(folder, fileName));

		return  form;
	}
	
	protected static Form produceFormFromSourceFile(String folder, String fileName) throws QBaseException
	{
		return produceFormFromSourceFile(folder, fileName, false);
	}

	protected static Stylesheet produceStylesheetFromSourceFileWithForm(String folder, String fileName, Form form) throws QBaseException
	{			
		Stylesheet stylesheet = new StylesheetFactory().stylesheet(SourceCodeTools.qlsUriTestForFolderAndFileName(folder, fileName), form);
		
		return stylesheet;	
	}
}
