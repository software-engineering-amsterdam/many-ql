package org.nlamah.QLS;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.QLTest;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Builders.QuestionStyleCombiner;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import junit.framework.TestCase;

public class QLStyleCombiningTest extends TestCase
{
	private Form parsedForm;
	private Stylesheet parsedStylesheet;

	public void testPageDefaultBlock() 
	{
		parsedForm = QLSTest.produceFormFromSourceFile("qls/stylecombine", "pagedefaultblock");
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFileWithoutForm("stylecombine", "pagedefaultblock");

		new QuestionStyleCombiner(parsedForm, parsedStylesheet).build();

		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();

		ColorDeclaration colorDeclaration = new ColorDeclaration(Color.decode("#FF0000"));
		styleDeclarations.add(colorDeclaration);

		StyleBlock styleBlock = new StyleBlock(styleDeclarations);

		StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);

		assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
	}

	public void testPageAndSectionDefault()
	{
		parsedForm = QLTest.produceFormFromSourceFile("qls/stylecombine", "pageandsectiondefault");
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFileWithoutForm("stylecombine", "pageandsectiondefault");

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

	public void testNestedSection()
	{
		parsedForm = QLTest.produceFormFromSourceFile("qls/stylecombine", "nestedsection");
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFileWithoutForm("stylecombine", "nestedsection");

		new QuestionStyleCombiner(parsedForm, parsedStylesheet).build();

		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();

		ColorDeclaration colorDeclaration = new ColorDeclaration(Color.decode("#000"));
		styleDeclarations.add(colorDeclaration);

		StyleBlock styleBlock = new StyleBlock(styleDeclarations);

		StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);

		assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
	}

	public void testMixed()
	{
		parsedForm = QLTest.produceFormFromSourceFile("qls/stylecombine", "mixed");
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFileWithoutForm("stylecombine", "mixed");

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
}