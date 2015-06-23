package org.nlamah.QLS;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseTestCase;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QLS.Builders.QuestionStyleCombiner;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.Value.IdentifierValue;;

public class QLStyleCombiningTest extends QBaseTestCase
{
	public void testPageDefaultBlock() 
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylecombine", "pagedefaultblock", true);
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylecombine", "pagedefaultblock", parsedForm);

			new QuestionStyleCombiner(parsedForm, parsedStylesheet).build();

			List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();

			ColorDeclaration colorDeclaration = new ColorDeclaration(Color.decode("#FF0000"));
			styleDeclarations.add(colorDeclaration);

			StyleBlock styleBlock = new StyleBlock(styleDeclarations);

			StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);

			assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		} 
	}

	public void testPageAndSectionDefault()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylecombine", "pageandsectiondefault", true);
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylecombine", "pageandsectiondefault", parsedForm);

			new QuestionStyleCombiner(parsedForm, parsedStylesheet).build();

			List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();

			ColorDeclaration colorDeclaration = new ColorDeclaration(Color.decode("#FF0000"));
			styleDeclarations.add(colorDeclaration);

			WidthDeclaration widthDeclaration = new WidthDeclaration(20);
			styleDeclarations.add(widthDeclaration);

			StyleBlock styleBlock = new StyleBlock(styleDeclarations);

			StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);

			assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		} 	
	}

	public void testNestedSection()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylecombine", "nestedsection", true);
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylecombine", "nestedsection", parsedForm);

			new QuestionStyleCombiner(parsedForm, parsedStylesheet).build();

			List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();

			ColorDeclaration colorDeclaration = new ColorDeclaration(Color.decode("#000"));
			styleDeclarations.add(colorDeclaration);

			StyleBlock styleBlock = new StyleBlock(styleDeclarations);

			StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);

			assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testMixed()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylecombine", "mixed", true);
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylecombine", "mixed", parsedForm);

			new QuestionStyleCombiner(parsedForm, parsedStylesheet).build();

			List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();

			FontSizeDeclaration fontSizeDeclaration = new FontSizeDeclaration(12);
			styleDeclarations.add(fontSizeDeclaration);

			WidthDeclaration widthDeclaration = new WidthDeclaration(9);
			styleDeclarations.add(widthDeclaration);

			FontDeclaration fontDeclaration = new FontDeclaration(Font.decode("Arial"));
			styleDeclarations.add(fontDeclaration);

			ColorDeclaration colorDeclaration = new ColorDeclaration(Color.decode("#000"));
			styleDeclarations.add(colorDeclaration);

			StyleBlock styleBlock = new StyleBlock(styleDeclarations);

			StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);

			assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}
}