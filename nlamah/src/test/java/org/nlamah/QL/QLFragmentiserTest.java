package org.nlamah.QL;

import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Builders.QLFormFragmentiser;
import org.nlamah.QL.Model.Form.Form;

import junit.framework.TestCase;

public class QLFragmentiserTest extends TestCase 
{
	private Form parsedForm;
	private Form referenceForm;

	public void testFragmentiser1() 
	{
		try 
		{
			parsedForm = QLTest.produceFormFromSourceFile("fragmentised", "1a", true);

			parsedForm = new QLFormFragmentiser(parsedForm).form();

			referenceForm = QLTest.produceFormFromSourceFile("fragmentised", "1b", true);

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		} 
	}
}