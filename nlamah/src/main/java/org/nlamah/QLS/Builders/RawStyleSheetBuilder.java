package org.nlamah.QLS.Builders;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QLS.QLSBaseVisitor;
import org.nlamah.QLS.QLSException;
import org.nlamah.QLS.QLSParser;
import org.nlamah.QLS.QLSParser.PageContext;
import org.nlamah.QLS.QLSParser.SectionContext;
import org.nlamah.QLS.QLSParser.SectionElementContext;
import org.nlamah.QLS.Model.IdentifierValue;
import org.nlamah.QLS.Model.Page;
import org.nlamah.QLS.Model.QLSNode;
import org.nlamah.QLS.Model.QLStylesheet;
import org.nlamah.QLS.Model.Section;
import org.nlamah.QLS.Model.SectionElement;
import org.nlamah.QLS.Model.TextValue;

public class RawStyleSheetBuilder extends QLSBaseVisitor<QLSNode> 
{
	public RawStyleSheetBuilder() 
	{
		super();
	}

	public QLStylesheet build(ParseTree tree) throws QLSException
	{
		return (QLStylesheet) tree.accept(this);
	}
	
	
	private void addSourceCodePosition(QLSNode node, ParserRuleContext ctx)
	{
		node.startsOnLine = ctx.getStart().getLine();
		node.startsAtCharacterPosition = ctx.getStart().getCharPositionInLine();
		node.nodeString = ctx.getStart().getText();
		node.endsOnLine = ctx.getStop().getLine();
		
		//TODO DRY
	}
	
	@Override 
	public QLSNode visitStylesheet(QLSParser.StylesheetContext ctx) 
	{ 		
		IdentifierValue identifier = new IdentifierValue(ctx.Identifier().getText());
		
		List<Page> pages = new ArrayList<Page>();
		
		for (PageContext contextualPage : ctx.page())
		{
			Page page = (Page) contextualPage.accept(this);
			pages.add(page);
		}
		
		QLStylesheet stylesheet = new QLStylesheet(identifier, pages);
		
		addSourceCodePosition(stylesheet, ctx);
		
		return stylesheet;
	}
	
	@Override 
	public QLSNode visitPage(QLSParser.PageContext ctx) 
	{ 
		IdentifierValue identifier = new IdentifierValue(ctx.Identifier().getText());
		
		List<Section> sections = new ArrayList<Section>();
		
		for (SectionContext contextualSection : ctx.section())
		{
			Section sectionDeclaration = (Section) contextualSection.accept(this);
			sections.add(sectionDeclaration);
		}
		
		Page page = new Page(identifier, sections);
		
		addSourceCodePosition(page, ctx);
		
		return page;
	}
	
	@Override 
	public QLSNode visitSection(QLSParser.SectionContext ctx) 
	{ 
		TextValue titleValue = new TextValue(ctx.Text().getText());
		
		List<SectionElement> sectionElements = new ArrayList<SectionElement>();
		
		for (SectionElementContext contextualSectionElement : ctx.sectionElement())
		{
			SectionElement sectionElement = (SectionElement) contextualSectionElement.accept(this);
			sectionElements.add(sectionElement);
		}
		
		Section section = new Section(titleValue, sectionElements);
		
		addSourceCodePosition(section, ctx);
		
		return section;
	}
	
	@Override 
	public QLSNode visitSectionDeclaration(QLSParser.SectionDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitQuestionDeclaration(QLSParser.QuestionDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitDefaultDeclaration(QLSParser.DefaultDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitStyleDeclaration(QLSParser.StyleDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitWidthDeclaration(QLSParser.WidthDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitFontDeclaration(QLSParser.FontDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitFontSizeDeclaration(QLSParser.FontSizeDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitColorDeclaration(QLSParser.ColorDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitWidgetDeclaration(QLSParser.WidgetDeclarationContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitWidgetType(QLSParser.WidgetTypeContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
}
