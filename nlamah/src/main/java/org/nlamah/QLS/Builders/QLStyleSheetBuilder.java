package org.nlamah.QLS.Builders;

import org.nlamah.QLS.QLSBaseVisitor;
import org.nlamah.QLS.QLSParser;
import org.nlamah.QLS.Model.QLSNode;

public class QLStyleSheetBuilder extends QLSBaseVisitor<QLSNode> 
{
	@Override 
	public QLSNode visitStylesheet(QLSParser.StylesheetContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitPage(QLSParser.PageContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public QLSNode visitSection(QLSParser.SectionContext ctx) 
	{ 
		return visitChildren(ctx); 
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
