package org.fugazi.qls.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ql.ast.AbstractASTQLNode;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.qls.ast.question.Question;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.style.NullStyle;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.style_property.*;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.widget.*;
import org.fugazi.qls.parser.QLSBaseVisitor;
import org.fugazi.qls.parser.QLSParser;

import java.util.ArrayList;

public class FugaziQLSVisitor extends QLSBaseVisitor<AbstractASTQLNode> {

    private String removeStringQuotes(String _str) {
        return _str.replaceAll("^\"|\"$", "");
    }

    private int getLineNumber(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
    }

    @Override 
    public AbstractASTQLSNode visitStylesheet(@NotNull QLSParser.StylesheetContext ctx) {
        String name = ctx.ID().getText();

        ArrayList<Page> pages = new ArrayList<>();
        for (QLSParser.PageContext pageContext : ctx.page()) {
            Page page = (Page) pageContext.accept(this);
            pages.add(page);
        }

        return new StyleSheet(name, pages);
    }
    
    @Override 
    public AbstractASTQLSNode visitPage(@NotNull QLSParser.PageContext ctx) {
        String name = ctx.ID().getText();

        ArrayList<Section> sections = new ArrayList<>();
        for (QLSParser.SectionContext sectionContext : ctx.section()) {
            Section section = (Section) sectionContext.accept(this);
            sections.add(section);
        }

        ArrayList<DefaultStyleDeclaration> defaultStyles = new ArrayList<>();
        for (QLSParser.DefaultStyleDeclrContext defaultStyleDeclrContext : ctx.defaultStyleDeclr()) {
            DefaultStyleDeclaration defaultStyle = (DefaultStyleDeclaration) defaultStyleDeclrContext.accept(this);
            defaultStyles.add(defaultStyle);
        }

		return new Page(name, sections, defaultStyles);
	}

    @Override 
    public AbstractASTQLSNode visitSection(@NotNull QLSParser.SectionContext ctx) {
        String name = ctx.STRING().getText();

        ArrayList<Section> sections = new ArrayList<>();
        for (QLSParser.SectionContext sectionContext : ctx.section()) {
            Section section = (Section) sectionContext.accept(this);
            sections.add(section);
        }

        ArrayList<Question> questions = new ArrayList<>();
        for (QLSParser.QuestionContext questionContext : ctx.question()) {
            Question question = (Question) questionContext.accept(this);
            questions.add(question);
        }

        ArrayList<DefaultStyleDeclaration> defaultStyles = new ArrayList<>();
        for (QLSParser.DefaultStyleDeclrContext defaultStyleDeclrContext : ctx.defaultStyleDeclr()) {
            DefaultStyleDeclaration defaultStyle = (DefaultStyleDeclaration) defaultStyleDeclrContext.accept(this);
            defaultStyles.add(defaultStyle);
        }

        return new Section(this.removeStringQuotes(name), sections, defaultStyles, questions);
	}

    @Override public AbstractASTQLSNode visitQuestionWithWidget(@NotNull QLSParser.QuestionWithWidgetContext ctx) {
        String identifier = ctx.ID().getText();

        Widget widget = (Widget) ctx.widget().accept(this);
        widget.setLabel(identifier);

        return new Question(identifier, widget);
    }

    @Override public AbstractASTQLSNode visitQuestionWithoutWidget(@NotNull QLSParser.QuestionWithoutWidgetContext ctx) {
        String identifier = ctx.ID().getText();
        return new Question(identifier, new NullWidget());
    }

    @Override 
	public AbstractASTQLSNode visitWidget(@NotNull QLSParser.WidgetContext ctx) {
		return (Widget) ctx.supportedWidget().accept(this);
	}
    
    @Override 
	public AbstractASTQLSNode visitNoStylesDefaultDeclr(@NotNull QLSParser.NoStylesDefaultDeclrContext ctx) {
        Type questionType = (Type) ctx.type().accept(this);
        Widget widget = (Widget) ctx.widget().accept(this);

        return new DefaultStyleDeclaration(new NullStyle(), widget, questionType);
    }
    
    @Override 
	public AbstractASTQLSNode visitStylesDefaultDeclr(@NotNull QLSParser.StylesDefaultDeclrContext ctx) {
        Type questionType = (Type) ctx.type().accept(this);
        Widget widget = (Widget) ctx.widget().accept(this);

        ArrayList<StyleProperty> styleProperties = new ArrayList<>();
        for (QLSParser.StylePropertyContext stylePropertyContext : ctx.styleProperty()) {
            StyleProperty styleProperty = (StyleProperty) stylePropertyContext.accept(this);
            styleProperties.add(styleProperty);
        }

        Style style = new Style(styleProperties);

        return new DefaultStyleDeclaration(style, widget, questionType);
	}
    
    @Override 
	public AbstractASTQLSNode visitCheckboxWidget(@NotNull QLSParser.CheckboxWidgetContext ctx) {
        return new CheckBox();
	}
    
    @Override 
	public AbstractASTQLSNode visitRadioWidget(@NotNull QLSParser.RadioWidgetContext ctx) {
        String yesLabel = ctx.yes.getText();
        String noLabel = ctx.no.getText();
		return new RadioBtn(this.removeStringQuotes(yesLabel), this.removeStringQuotes(noLabel));
	}
    
    @Override 
	public AbstractASTQLSNode visitDropdownWidget(@NotNull QLSParser.DropdownWidgetContext ctx) {
        String yesLabel = ctx.yes.getText();
        String noLabel = ctx.no.getText();
        return new Dropdown(this.removeStringQuotes(yesLabel), this.removeStringQuotes(noLabel));
	}
    
    @Override 
	public AbstractASTQLSNode visitSpinboxWidget(@NotNull QLSParser.SpinboxWidgetContext ctx) {
		return new SpinBox();
	}
    
    @Override 
	public AbstractASTQLSNode visitSliderWidget(@NotNull QLSParser.SliderWidgetContext ctx) {
		return new Slider();
	}
    
    @Override 
	public AbstractASTQLSNode visitTextWidget(@NotNull QLSParser.TextWidgetContext ctx) {
		return new TextBox();
	}
    
    @Override 
	public AbstractASTQLSNode visitWidthStyleProperty(@NotNull QLSParser.WidthStylePropertyContext ctx) {
        Integer value = Integer.parseInt(ctx.NUMBER().getText());
		return new Width(value);
	}
    
    @Override
	public AbstractASTQLSNode visitFontStyleProperty(@NotNull QLSParser.FontStylePropertyContext ctx) {
        String value = ctx.STRING().getText();
		return new Font(this.removeStringQuotes(value));
	}
    
    @Override 
	public AbstractASTQLSNode visitFontsizeStyleProperty(@NotNull QLSParser.FontsizeStylePropertyContext ctx) {
        Integer value = Integer.parseInt(ctx.NUMBER().getText());
        return new FontSize(value);
	}
    
    @Override 
	public AbstractASTQLSNode visitColorStyleProperty(@NotNull QLSParser.ColorStylePropertyContext ctx) {
        String value = ctx.HEX().getText();
        return new Color(value);
	}
    
    @Override 
	public AbstractASTQLNode visitBoolType(@NotNull QLSParser.BoolTypeContext ctx) {
		return new BoolType(this.getLineNumber(ctx));
	}
    
    @Override 
	public AbstractASTQLNode visitIntType(@NotNull QLSParser.IntTypeContext ctx) {
        return new IntType(this.getLineNumber(ctx));
	}
    
    @Override 
    public AbstractASTQLNode visitStringType(@NotNull QLSParser.StringTypeContext ctx) {
        return new StringType(this.getLineNumber(ctx));
	}
}
