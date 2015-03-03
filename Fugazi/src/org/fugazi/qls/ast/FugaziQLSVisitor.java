package org.fugazi.qls.ast;

import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.qls.parser.QLSBaseVisitor;
import org.fugazi.qls.parser.QLSParser;

public class FugaziQLSVisitor extends QLSBaseVisitor<AbstractASTNode> {

    @Override 
    public AbstractASTNode visitStylesheet(@NotNull QLSParser.StylesheetContext ctx) { 
        return null; 
    }
    
    @Override 
    public AbstractASTNode visitPage(@NotNull QLSParser.PageContext ctx) { 
		return null; 
	}

    @Override 
    public AbstractASTNode visitSection(@NotNull QLSParser.SectionContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitQuestion(@NotNull QLSParser.QuestionContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitWidget(@NotNull QLSParser.WidgetContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitNoStylesDefaultDeclr(@NotNull QLSParser.NoStylesDefaultDeclrContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitStylesDefaultDeclr(@NotNull QLSParser.StylesDefaultDeclrContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitCheckboxWidget(@NotNull QLSParser.CheckboxWidgetContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitRadioWidget(@NotNull QLSParser.RadioWidgetContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitDropdownWidget(@NotNull QLSParser.DropdownWidgetContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitSpinboxWidget(@NotNull QLSParser.SpinboxWidgetContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitSliderWidget(@NotNull QLSParser.SliderWidgetContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitTextWidget(@NotNull QLSParser.TextWidgetContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitWidthStyleProperty(@NotNull QLSParser.WidthStylePropertyContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitFontStyleProperty(@NotNull QLSParser.FontStylePropertyContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitFontsizeStyleProperty(@NotNull QLSParser.FontsizeStylePropertyContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitColorStyleProperty(@NotNull QLSParser.ColorStylePropertyContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitBoolType(@NotNull QLSParser.BoolTypeContext ctx) { 
		return null; 
	}
    
    @Override 
	public AbstractASTNode visitIntType(@NotNull QLSParser.IntTypeContext ctx) { 
		return null; 
	}
    
    @Override 
    public AbstractASTNode visitStringType(@NotNull QLSParser.StringTypeContext ctx) { 
		return null; 
	}
}
