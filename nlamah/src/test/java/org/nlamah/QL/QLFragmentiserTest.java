package org.nlamah.QL;

import org.nlamah.QL.Builders.QLFormFragmentiser;
import org.nlamah.QL.Model.Form.Form;

import junit.framework.TestCase;

public class QLFragmentiserTest extends TestCase 
{
	private Form parsedForm;
	private Form referenceForm;
	
	public void testFragmentiser() 
	{
		parsedForm = QLTest.produceFormFromSourceFile("fragmentised", "1a");
		
		parsedForm = new QLFormFragmentiser(parsedForm).form();
		
		referenceForm = QLTest.produceFormFromSourceFile("fragmentised", "1b");
		
		assertEquals(parsedForm, referenceForm);
	}
}