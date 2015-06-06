package org.nlamah.QLS;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.QBaseTestCase;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.StyleBlock;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.WidgetTypeEnum;

public class QLStylesheetTest extends QBaseTestCase
{
	public void testEmptyStylesheet() 
	{	
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "emptystylesheet", parsedForm);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), new ArrayList<Page>(), new ArrayList<DefaultBlock>());

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		} 
	}

	public void testOnepage()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "onepage", parsedForm);

			Page page = new Page(new IdentifierValue("testpage"), new ArrayList<Section>(), new ArrayList<DefaultBlock>());

			List<Page> pages = new ArrayList<Page>();
			pages.add(page);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testOneSection()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "onesection", parsedForm);

			Section section = new Section("testsection", new ArrayList<SectionItem>(), new ArrayList<DefaultBlock>());

			List<Section> sections = new ArrayList<Section>();
			sections.add(section);

			Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultBlock>());

			List<Page> pages = new ArrayList<Page>();
			pages.add(page);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testOneQuestion()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "onequestion", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "onequestion", parsedForm);

			StyledQuestion styledQuestion = new StyledQuestion(new IdentifierValue("testquestion"), new StyleBlock(new ArrayList<StyleDeclaration>()));

			List<StyledQuestion> questions = new ArrayList<StyledQuestion>();
			questions.add(styledQuestion);

			Section section = new Section("testsection", questions, new ArrayList<DefaultBlock>());

			List<Section> sections = new ArrayList<Section>();
			sections.add(section);

			Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultBlock>());

			List<Page> pages = new ArrayList<Page>();
			pages.add(page);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testOneWidgetQuestion()
	{
		try 
		{			
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "onequestion", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "onewidgetquestion", parsedForm);

			WidgetDeclaration widgetDeclaration= new WidgetDeclaration(WidgetTypeEnum.CHECKBOX, QBaseQuestionType.BOOLEAN, null);

			List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();

			styleDeclarations.add(widgetDeclaration);

			StyleBlock styleBlock = new StyleBlock(styleDeclarations);

			StyledQuestion styledQuestion = new StyledQuestion(new IdentifierValue("testquestion"), styleBlock);

			List<StyledQuestion> questions = new ArrayList<StyledQuestion>();
			questions.add(styledQuestion);

			Section section = new Section("testsection", questions, new ArrayList<DefaultBlock>());

			List<Section> sections = new ArrayList<Section>();
			sections.add(section);

			Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultBlock>());

			List<Page> pages = new ArrayList<Page>();
			pages.add(page);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testdefaultBlocksSheet()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "defaultblocksheet", parsedForm);

			DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());

			List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
			defaultBlocks.add(defaultBlock);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultBlocks);

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testdefaultBlocksPage()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "defaultblockpage", parsedForm);

			DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());

			List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
			defaultBlocks.add(defaultBlock);

			Page page = new Page(new IdentifierValue("testpage"), new ArrayList<Section>(), defaultBlocks);

			List<Page> pages = new ArrayList<Page>();
			pages.add(page);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testdefaultBlocksSection()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "defaultblocksection", parsedForm);

			DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());

			List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
			defaultBlocks.add(defaultBlock);

			Section section = new Section("testsection", new ArrayList<SectionItem>(), defaultBlocks);

			List<Section> sections = new ArrayList<Section>();
			sections.add(section);

			Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultBlock>());

			List<Page> pages = new ArrayList<Page>();
			pages.add(page);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}	
	}

	public void testRadioButton()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "radiobutton", parsedForm);

			Map<TextLiteral, TextLiteral> answers = new LinkedHashMap<TextLiteral, TextLiteral>();
			TextLiteral value1 = new TextLiteral("value1");
			answers.put(value1, value1);
			TextLiteral value2 = new TextLiteral("value2");
			answers.put(value2, value2);
			TextLiteral value3 = new TextLiteral("value3");
			answers.put(value3, value3);
			TextLiteral value4 = new TextLiteral("value4");
			answers.put(value4, value4);
			TextLiteral value5 = new TextLiteral("value5");
			answers.put(value5, value5);
			TextLiteral value6 = new TextLiteral("value6");
			answers.put(value6, value6);
			TextLiteral value7 = new TextLiteral("value7");
			answers.put(value7, value7);

			WidgetDeclaration widgetDeclaration = new WidgetDeclaration(WidgetTypeEnum.RADIOBUTTON, QBaseQuestionType.TEXT, answers);

			List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
			styleDeclarations.add(widgetDeclaration);

			DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.TEXT, styleDeclarations);

			List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
			defaultBlocks.add(defaultBlock);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultBlocks);

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}

	public void testNestedSections()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "nestedsections", parsedForm);

			List<SectionItem> nestedSections = new ArrayList<SectionItem>();
			Section nestedSection1 = new Section("nestedsection1", new ArrayList<SectionItem>(), new ArrayList<DefaultBlock>());
			nestedSections.add(nestedSection1);

			List<SectionItem> nestedSectionsInNestedSection2 = new ArrayList<SectionItem>();
			Section nestedSection21 = new Section("nestedsection2.1", new ArrayList<SectionItem>(), new ArrayList<DefaultBlock>());
			nestedSectionsInNestedSection2.add(nestedSection21);

			Section nestedSection2 = new Section("nestedsection2", nestedSectionsInNestedSection2, new ArrayList<DefaultBlock>());
			nestedSections.add(nestedSection2);

			List<Section> pageSections = new ArrayList<Section>();
			Section section = new Section("testsection", nestedSections, new ArrayList<DefaultBlock>());
			pageSections.add(section);

			Page page = new Page(new IdentifierValue("testpage"), pageSections, new ArrayList<DefaultBlock>());

			List<Page> pages = new ArrayList<Page>();
			pages.add(page);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}	
	}

	public void testDefaultBlockFilled()
	{
		try 
		{
			parsedForm = produceFormFromSourceFile("qls/stylesheet", "emptyform", true);
			
			parsedStylesheet = produceStylesheetFromSourceFileWithForm("stylesheet", "defaultblockfilled", parsedForm);

			List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();

			styleDeclarations.add(new WidthDeclaration(400));
			styleDeclarations.add(new FontDeclaration(Font.decode("Arial")));
			styleDeclarations.add(new FontSizeDeclaration(14));
			styleDeclarations.add(new ColorDeclaration(Color.decode("#999999")));
			styleDeclarations.add(new WidgetDeclaration(WidgetTypeEnum.SPINBOX, QBaseQuestionType.NUMBER, null));

			DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.NUMBER, styleDeclarations);

			List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
			defaultBlocks.add(defaultBlock);

			referenceStylesheet = new Stylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultBlocks);

			assertEquals(parsedStylesheet, referenceStylesheet);
		} 
		catch (QBaseException exception) 
		{
			assertTrue(false);
		}
	}
}