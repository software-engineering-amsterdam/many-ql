package org.nlamah.QLS;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.QLTest;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Builders.CombinedStylesForQuestionsBuilder;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.Value.ColorValue;
import org.nlamah.QLS.Model.Value.FontValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;

import junit.framework.TestCase;

public class QLStyleCombiningTest extends TestCase
{
	private Form parsedForm;
	private Stylesheet parsedStylesheet;
	
	public void testPageDefaultBlock() 
	{
		parsedForm = QLTest.produceFormFromSourceFile("qls/stylecombine", "pagedefaultblock");
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylecombine", "pagedefaultblock");
		
		new CombinedStylesForQuestionsBuilder(parsedForm, parsedStylesheet).build();
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		ColorDeclaration colorDeclaration = new ColorDeclaration(new ColorValue(Color.decode("#F00")));
		styleDeclarations.add(colorDeclaration);
		
		StyleBlock styleBlock = new StyleBlock(styleDeclarations);
		
		StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);
		
		assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
	}
	
	public void testPageAndSectionDefault()
	{
		parsedForm = QLTest.produceFormFromSourceFile("qls/stylecombine", "pageandsectiondefault");
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylecombine", "pageandsectiondefault");
		
		new CombinedStylesForQuestionsBuilder(parsedForm, parsedStylesheet).build();
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		ColorDeclaration colorDeclaration = new ColorDeclaration(new ColorValue(Color.decode("#F00")));
		styleDeclarations.add(colorDeclaration);
		
		WidthDeclaration widthDeclaration = new WidthDeclaration(new NumberValue(20));
		styleDeclarations.add(widthDeclaration);
		
		StyleBlock styleBlock = new StyleBlock(styleDeclarations);
		
		StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);
		
		assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
	}
	
	public void testNestedSection()
	{
		parsedForm = QLTest.produceFormFromSourceFile("qls/stylecombine", "nestedsection");
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylecombine", "nestedsection");
		
		new CombinedStylesForQuestionsBuilder(parsedForm, parsedStylesheet).build();
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		ColorDeclaration colorDeclaration = new ColorDeclaration(new ColorValue(Color.decode("#000")));
		styleDeclarations.add(colorDeclaration);
		
		StyleBlock styleBlock = new StyleBlock(styleDeclarations);
		
		StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);
		
		assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
	}
	
	public void testMixed()
	{
		parsedForm = QLTest.produceFormFromSourceFile("qls/stylecombine", "mixed");
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylecombine", "mixed");
		
		new CombinedStylesForQuestionsBuilder(parsedForm, parsedStylesheet).build();
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		FontSizeDeclaration fontSizeDeclaration = new FontSizeDeclaration(new NumberValue(12));
		styleDeclarations.add(fontSizeDeclaration);
		
		WidthDeclaration widthDeclaration = new WidthDeclaration(new NumberValue(9));
		styleDeclarations.add(widthDeclaration);
		
		FontDeclaration fontDeclaration = new FontDeclaration(new FontValue(Font.decode("Arial")));
		styleDeclarations.add(fontDeclaration);
		
		ColorDeclaration colorDeclaration = new ColorDeclaration(new ColorValue(Color.decode("#000")));
		styleDeclarations.add(colorDeclaration);
		
		StyleBlock styleBlock = new StyleBlock(styleDeclarations);
		
		StyledQuestion referenceQuestion = new StyledQuestion(new IdentifierValue("question1"), styleBlock);
		
		assertEquals(parsedStylesheet.questions().get(0), referenceQuestion);
	}
}
