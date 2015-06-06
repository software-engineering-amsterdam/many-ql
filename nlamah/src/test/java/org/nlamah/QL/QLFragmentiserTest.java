package org.nlamah.QL;

import org.nlamah.QBase.QBaseTestCase;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Builders.QLFormFragmentiser;

public class QLFragmentiserTest extends QBaseTestCase 
{
	public void testFragmentiser1() 
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("fragmentised", "1a");

			parsedForm = new QLFormFragmentiser(parsedForm).form();

			referenceForm = produceFormFromSourceFile("fragmentised", "1b");

			assertEquals(parsedForm, referenceForm);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		} 
	}
}