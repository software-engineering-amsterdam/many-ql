package org.nlamah.QLS;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QLS.Builders.RawStylesheetBuilder;
import org.nlamah.QLS.Error.FontRecognitionError;

import junit.framework.TestCase;

public class QLStylesheetErrorTest extends TestCase
{
	public void testIllegalFontName() 
	{
		ParseTree tree = QLSTest.produceParseTreeFromSourceFile("error", "illegalfontname");

		RawStylesheetBuilder stylesheetBuilder = new RawStylesheetBuilder();
		
		stylesheetBuilder.build(tree);
		
		List<QBaseError> referenceErrors = new ArrayList<QBaseError>();
		QBaseError error = new FontRecognitionError("", 0, 0);
		referenceErrors.add(error);

		assertEquals(stylesheetBuilder.errors(), referenceErrors);
	}
}
