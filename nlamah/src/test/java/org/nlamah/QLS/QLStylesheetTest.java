package org.nlamah.QLS;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Abstract.WidgetType;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.QuestionDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.HexNumberValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

public class QLStylesheetTest extends TestCase
{

	private QLStylesheet parsedStylesheet;
	private QLStylesheet referenceStylesheet;

	public void testEmptyStylesheet() 
	{	
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "emptystylesheet");
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), new ArrayList<Page>(), new ArrayList<DefaultDeclaration>());
		
	    assertEquals(parsedStylesheet, referenceStylesheet);  
	}
	
	public void testOnepage()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onepage");
		
		Page page = new Page(new IdentifierValue("testpage"), new ArrayList<Section>(), new ArrayList<DefaultDeclaration>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testOneSection()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onesection");
		
		Section section = new Section(new TextValue("testsection"), new ArrayList<Section>(), new ArrayList<QuestionDeclaration>(), new ArrayList<DefaultDeclaration>());
		
		List<Section> sections = new ArrayList<Section>();
		sections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultDeclaration>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testOneQuestion()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onequestion");
		
		QuestionDeclaration questionDeclaration = new QuestionDeclaration(new IdentifierValue("testquestion"), null);
		
		List<QuestionDeclaration> questions = new ArrayList<QuestionDeclaration>();
		questions.add(questionDeclaration);
		
		Section section = new Section(new TextValue("testsection"), new ArrayList<Section>(), questions, new ArrayList<DefaultDeclaration>());
		
		List<Section> sections = new ArrayList<Section>();
		sections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultDeclaration>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testOneWidgetQuestion()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onewidgetquestion");
		
		WidgetType widgetType = new CheckBoxWidgetType();
		
		WidgetDeclaration widgetDeclaration= new WidgetDeclaration(widgetType);
		
		QuestionDeclaration questionDeclaration = new QuestionDeclaration(new IdentifierValue("testquestion"), widgetDeclaration);
		
		List<QuestionDeclaration> questions = new ArrayList<QuestionDeclaration>();
		questions.add(questionDeclaration);
		
		Section section = new Section(new TextValue("testsection"), new ArrayList<Section>(), questions, new ArrayList<DefaultDeclaration>());
		
		List<Section> sections = new ArrayList<Section>();
		sections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultDeclaration>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testDefaultDeclarationsSheet()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "defaultdeclarationsheet");
		
		DefaultDeclaration defaultDeclaration = new DefaultDeclaration(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());
		
		List<DefaultDeclaration> defaultDeclarations = new ArrayList<DefaultDeclaration>();
		defaultDeclarations.add(defaultDeclaration);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultDeclarations);
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testDefaultDeclarationsPage()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "defaultdeclarationpage");
		
		DefaultDeclaration defaultDeclaration = new DefaultDeclaration(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());
		
		List<DefaultDeclaration> defaultDeclarations = new ArrayList<DefaultDeclaration>();
		defaultDeclarations.add(defaultDeclaration);
		
		Page page = new Page(new IdentifierValue("testpage"), new ArrayList<Section>(), defaultDeclarations);
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testDefaultDeclarationsSection()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "defaultdeclarationsection");
		
		DefaultDeclaration defaultDeclaration = new DefaultDeclaration(QBaseQuestionType.NUMBER, new ArrayList<StyleDeclaration>());
		
		List<DefaultDeclaration> defaultDeclarations = new ArrayList<DefaultDeclaration>();
		defaultDeclarations.add(defaultDeclaration);
		
		Section section = new Section(new TextValue("testsection"), new ArrayList<Section>(), new ArrayList<QuestionDeclaration>(), defaultDeclarations);
		
		List<Section> sections = new ArrayList<Section>();
		sections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultDeclaration>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
		
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
		
		DefaultDeclaration defaultDeclaration = new DefaultDeclaration(QBaseQuestionType.TEXT, styleDeclarations);
		
		List<DefaultDeclaration> defaultDeclarations = new ArrayList<DefaultDeclaration>();
		defaultDeclarations.add(defaultDeclaration);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultDeclarations);
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testNestedSections()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "nestedsections");
		
		List<Section> nestedSections = new ArrayList<Section>();
		Section nestedSection1 = new Section(new TextValue("nestedsection1"), new ArrayList<Section>(), new ArrayList<QuestionDeclaration>(), new ArrayList<DefaultDeclaration>());
		nestedSections.add(nestedSection1);
		
		List<Section> nestedSectionsInNestedSection2 = new ArrayList<Section>();
		Section nestedSection21 = new Section(new TextValue("nestedsection2.1"), new ArrayList<Section>(), new ArrayList<QuestionDeclaration>(), new ArrayList<DefaultDeclaration>());
		nestedSectionsInNestedSection2.add(nestedSection21);
		
		Section nestedSection2 = new Section(new TextValue("nestedsection2"), nestedSectionsInNestedSection2, new ArrayList<QuestionDeclaration>(), new ArrayList<DefaultDeclaration>());
		nestedSections.add(nestedSection2);
			
		List<Section> pageSections = new ArrayList<Section>();
		Section section = new Section(new TextValue("testsection"), nestedSections, new ArrayList<QuestionDeclaration>(), new ArrayList<DefaultDeclaration>());
		pageSections.add(section);
		
		Page page = new Page(new IdentifierValue("testpage"), pageSections, new ArrayList<DefaultDeclaration>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	public void testDefaultDeclarationFilled()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "defaultdeclarationfilled");
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		styleDeclarations.add(new WidthDeclaration(new NumberValue("400")));
		styleDeclarations.add(new FontDeclaration(new TextValue("Arial")));
		styleDeclarations.add(new FontSizeDeclaration(new NumberValue("14")));
		styleDeclarations.add(new ColorDeclaration(new HexNumberValue("#999999")));
		styleDeclarations.add(new WidgetDeclaration(new SpinBoxWidgetType()));
		
		DefaultDeclaration defaultDeclaration = new DefaultDeclaration(QBaseQuestionType.NUMBER, styleDeclarations);
		
		List<DefaultDeclaration> defaultDeclarations = new ArrayList<DefaultDeclaration>();
		defaultDeclarations.add(defaultDeclaration);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), new ArrayList<Page>(), defaultDeclarations);
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
}
