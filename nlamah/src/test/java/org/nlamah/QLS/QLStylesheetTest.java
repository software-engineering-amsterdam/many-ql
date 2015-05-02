package org.nlamah.QLS;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.nlamah.QLS.Model.Abstract.WidgetType;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.QuestionDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;

public class QLStylesheetTest extends TestCase
{

	private QLStylesheet parsedStylesheet;
	private QLStylesheet referenceStylesheet;

//	public void testEmptyStylesheet() 
//	{	
//		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "emptystylesheet");
//		
//		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), new ArrayList<Page>(), new ArrayList<DefaultDeclaration>());
//		
//	    assertEquals(parsedStylesheet, referenceStylesheet);  
//	}
//	
//	public void testOnepage()
//	{
//		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onepage");
//		
//		Page page = new Page(new IdentifierValue("testpage"), new ArrayList<Section>(), new ArrayList<DefaultDeclaration>());
//		
//		List<Page> pages = new ArrayList<Page>();
//		pages.add(page);
//		
//		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
//		
//		assertEquals(parsedStylesheet, referenceStylesheet);
//	}
//	
//	public void testOneSection()
//	{
//		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onesection");
//		
//		Section section = new Section(new TextValue("testsection"), new ArrayList<Section>(), new ArrayList<QuestionDeclaration>(), new ArrayList<DefaultDeclaration>());
//		
//		List<Section> sections = new ArrayList<Section>();
//		sections.add(section);
//		
//		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultDeclaration>());
//		
//		List<Page> pages = new ArrayList<Page>();
//		pages.add(page);
//		
//		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
//		
//		assertEquals(parsedStylesheet, referenceStylesheet);
//	}
//	
//	public void testOneQuestion()
//	{
//		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onequestion");
//		
//		QuestionDeclaration questionDeclaration = new QuestionDeclaration(new IdentifierValue("testquestion"), null);
//		
//		List<QuestionDeclaration> questions = new ArrayList<QuestionDeclaration>();
//		questions.add(questionDeclaration);
//		
//		Section section = new Section(new TextValue("testsection"), new ArrayList<Section>(), questions, new ArrayList<DefaultDeclaration>());
//		
//		List<Section> sections = new ArrayList<Section>();
//		sections.add(section);
//		
//		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultDeclaration>());
//		
//		List<Page> pages = new ArrayList<Page>();
//		pages.add(page);
//		
//		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
//		
//		assertEquals(parsedStylesheet, referenceStylesheet);
//	}
//	
//	public void testOneWidgetQuestion()
//	{
//		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "onewidgetquestion");
//		
//		WidgetType widgetType = new CheckBoxWidgetType();
//		
//		WidgetDeclaration widgetDeclaration= new WidgetDeclaration(widgetType);
//		
//		QuestionDeclaration questionDeclaration = new QuestionDeclaration(new IdentifierValue("testquestion"), widgetDeclaration);
//		
//		List<QuestionDeclaration> questions = new ArrayList<QuestionDeclaration>();
//		questions.add(questionDeclaration);
//		
//		Section section = new Section(new TextValue("testsection"), new ArrayList<Section>(), questions, new ArrayList<DefaultDeclaration>());
//		
//		List<Section> sections = new ArrayList<Section>();
//		sections.add(section);
//		
//		Page page = new Page(new IdentifierValue("testpage"), sections, new ArrayList<DefaultDeclaration>());
//		
//		List<Page> pages = new ArrayList<Page>();
//		pages.add(page);
//		
//		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
//		
//		assertEquals(parsedStylesheet, referenceStylesheet);
//	}
	
	public void testSheetDefaultDeclaration()
	{
		parsedStylesheet = QLSTest.produceStylesheetFromSourceFile("stylesheet", "sheetdefaultdeclaration");
		
		Page page = new Page(new IdentifierValue("testpage"), new ArrayList<Section>(), new ArrayList<DefaultDeclaration>());
		
		List<Page> pages = new ArrayList<Page>();
		pages.add(page);
		
		referenceStylesheet = new QLStylesheet(new IdentifierValue("test"), pages, new ArrayList<DefaultDeclaration>());
		
		assertEquals(parsedStylesheet, referenceStylesheet);
	}
	
	
}
