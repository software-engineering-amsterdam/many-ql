package org.nlamah.QLS;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Abstract.WidgetType;
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
import org.nlamah.QLS.Model.Value.ColorValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

public class QLStylesheetTest extends TestCase
{
	private Stylesheet parsedStylesheet;
	private Stylesheet referenceStylesheet;

	public void testEmptyStylesheet() 
	{	
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "emptystylesheet");
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), new ArrayList<Page>(), new ArrayList<DefaultBlock>());
		
	    assertEquals(parsedStylesheet, referenceStylesheet);  
	}
	
	public void testOnepage()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onepage");
		
		Page page = new Page(new IdentifierValue("testpage"), new ArrayList<Section>(), new ArrayList<DefaultBlock>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testOneSection()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onesection");
		
		Section section = new Section(new TextValue("testsection"), new ArrayList<SectionItem>(), new ArrayList<DefaultBlock>());
		
		List<Section> sections = new ArrayList<Section>();
		sections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultBlock>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testOneQuestion()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onequestion");
		
		
		
		StyledQuestion styledQuestion = new StyledQuestion(new IdentifierValue("testquestion"), new StyleBlock(new ArrayList<StyleDeclaration>()));
		
		List<StyledQuestion> questions = new ArrayList<StyledQuestion>();
		questions.add(styledQuestion);
		
		Section section = new Section(new TextValue("testsection"), questions, new ArrayList<DefaultBlock>());
		
		List<Section> sections = new ArrayList<Section>();
		sections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultBlock>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testOneWidgetQuestion()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onewidgetquestion");
		
		WidgetType widgetType = new CheckBoxWidgetType();
		
		WidgetDeclaration widgetDeclaration= new WidgetDeclaration(widgetType);
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		styleDeclarations.add(widgetDeclaration);
		
		StyleBlock styleBlock = new StyleBlock(styleDeclarations);
		
		StyledQuestion styledQuestion = new StyledQuestion(new IdentifierValue("testquestion"), styleBlock);
		
		List<StyledQuestion> questions = new ArrayList<StyledQuestion>();
		questions.add(styledQuestion);
		
		Section section = new Section(new TextValue("testsection"), questions, new ArrayList<DefaultBlock>());
		
		List<Section> sections = new ArrayList<Section>();
		sections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultBlock>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testdefaultBlocksSheet()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "defaultblocksheet");
		
		DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());
		
		List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
		defaultBlocks.add(defaultBlock);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultBlocks);
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testdefaultBlocksPage()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "defaultblockpage");
		
		DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());
		
		List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
		defaultBlocks.add(defaultBlock);
		
		Page page = new Page(new IdentifierValue("testpage"), new ArrayList<Section>(), defaultBlocks);
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testdefaultBlocksSection()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "defaultblocksection");
		
		DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());
		
		List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
		defaultBlocks.add(defaultBlock);
		
		Section section = new Section(new TextValue("testsection"), new ArrayList<SectionItem>(), defaultBlocks);
		
		List<Section> sections = new ArrayList<Section>();
		sections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultBlock>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testRadioButton()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "radiobutton");
		
		List<TextValue> answers = new ArrayList<TextValue>();
		TextValue value1 = new TextValue("value1");
		answers.add(value1);
		TextValue value2 = new TextValue("value2");
		answers.add(value2);
		TextValue value3 = new TextValue("value3");
		answers.add(value3);
		TextValue value4 = new TextValue("value4");
		answers.add(value4);
		TextValue value5 = new TextValue("value5");
		answers.add(value5);
		TextValue value6 = new TextValue("value6");
		answers.add(value6);
		TextValue value7 = new TextValue("value7");
		answers.add(value7);
		
		WidgetType widgetType = new RadioButtonWidgetType(answers);
		WidgetDeclaration widgetDeclaration = new WidgetDeclaration(widgetType);
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		styleDeclarations.add(widgetDeclaration);
		
		DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.TEXT, styleDeclarations);
		
		List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
		defaultBlocks.add(defaultBlock);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultBlocks);
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testNestedSections()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "nestedsections");
		
		List<SectionItem> nestedSections = new ArrayList<SectionItem>();
		Section nestedSection1 = new Section(new TextValue("nestedsection1"), new ArrayList<SectionItem>(), new ArrayList<DefaultBlock>());
		nestedSections.add(nestedSection1);
		
		List<SectionItem> nestedSectionsInNestedSection2 = new ArrayList<SectionItem>();
		Section nestedSection21 = new Section(new TextValue("nestedsection2.1"), new ArrayList<SectionItem>(), new ArrayList<DefaultBlock>());
		nestedSectionsInNestedSection2.add(nestedSection21);
		
		Section nestedSection2 = new Section(new TextValue("nestedsection2"), nestedSectionsInNestedSection2, new ArrayList<DefaultBlock>());
		nestedSections.add(nestedSection2);
			
		List<Section> pageSections = new ArrayList<Section>();
		Section section = new Section(new TextValue("testsection"), nestedSections, new ArrayList<DefaultBlock>());
		pageSections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), pageSections, new ArrayList<DefaultBlock>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultBlock>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testdefaultBlockFilled()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "defaultblockfilled");
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		styleDeclarations.add(new WidthDeclaration(new NumberValue(400)));
		styleDeclarations.add(new FontDeclaration(new TextValue("Arial")));
		styleDeclarations.add(new FontSizeDeclaration(new NumberValue(14)));
		styleDeclarations.add(new ColorDeclaration(new ColorValue(Color.decode("#999999"))));
		styleDeclarations.add(new WidgetDeclaration(new SpinBoxWidgetType()));
		
		DefaultBlock defaultBlock = new DefaultBlock(QBaseQuestionType.NUMBER, styleDeclarations);
		
		List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();
		defaultBlocks.add(defaultBlock);
		
		referenceStylesheet = new Stylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultBlocks);
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
}
