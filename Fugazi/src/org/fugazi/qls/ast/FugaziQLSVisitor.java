package org.fugazi.qls.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.qls.ast.question.Question;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.style.UndefinedStyle;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.style_property.*;
import org.fugazi.qls.ast.style.style_property.type.IntPropertyType;
import org.fugazi.qls.ast.style.style_property.type.StringPropertyType;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.widget.*;
import org.fugazi.qls.parser.QLSBaseVisitor;
import org.fugazi.qls.parser.QLSParser;

import java.util.ArrayList;
import java.util.List;

public class FugaziQLSVisitor extends QLSBaseVisitor<AbstractASTNode> {

    private String removeStringQuotes(String _str) {
        return _str.replaceAll("^\"|\"$", "");
    }

    private int getLineNumber(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
    }

    @Override 
    public AbstractASTNode visitStylesheet(@NotNull QLSParser.StylesheetContext ctx) {
        String name = ctx.ID().getText();

        List<Page> pages = new ArrayList<>();
        for (QLSParser.PageContext pageContext : ctx.page()) {
            Page page = (Page) pageContext.accept(this);
            pages.add(page);
        }

        return new StyleSheet(this.getLineNumber(ctx), name, pages);
    }
    
    @Override 
    public AbstractASTNode visitPage(@NotNull QLSParser.PageContext ctx) {
        String name = ctx.ID().getText();

        List<Section> sections = new ArrayList<>();
        for (QLSParser.SectionContext sectionContext : ctx.section()) {
            Section section = (Section) sectionContext.accept(this);
            sections.add(section);
        }

        List<DefaultStyleDeclaration> defaultStyles = new ArrayList<>();
        for (QLSParser.DefaultStyleDeclrContext defaultStyleDeclrContext : ctx.defaultStyleDeclr()) {
            DefaultStyleDeclaration defaultStyle = (DefaultStyleDeclaration) defaultStyleDeclrContext.accept(this);
            defaultStyles.add(defaultStyle);
        }

		return new Page(this.getLineNumber(ctx), name, sections, defaultStyles);
	}

    @Override 
    public AbstractASTNode visitSection(@NotNull QLSParser.SectionContext ctx) {
        String name = ctx.STRING().getText();

        List<Section> sections = new ArrayList<>();
        for (QLSParser.SectionContext sectionContext : ctx.section()) {
            Section section = (Section) sectionContext.accept(this);
            sections.add(section);
        }

        List<Question> questions = new ArrayList<>();
        for (QLSParser.QuestionContext questionContext : ctx.question()) {
            Question question = (Question) questionContext.accept(this);
            questions.add(question);
        }

        List<DefaultStyleDeclaration> defaultStyles = new ArrayList<>();
        for (QLSParser.DefaultStyleDeclrContext defaultStyleDeclrContext : ctx.defaultStyleDeclr()) {
            DefaultStyleDeclaration defaultStyle = (DefaultStyleDeclaration) defaultStyleDeclrContext.accept(this);
            defaultStyles.add(defaultStyle);
        }

        return new Section(this.getLineNumber(ctx), this.removeStringQuotes(name), sections, defaultStyles, questions);
	}

    @Override public AbstractASTNode visitQuestionWithWidget(@NotNull QLSParser.QuestionWithWidgetContext ctx) {
        String identifier = ctx.ID().getText();

        Widget widget = (Widget) ctx.widget().accept(this);
        widget.setLabel(identifier);

        return new Question(this.getLineNumber(ctx), identifier, widget);
    }

    @Override public AbstractASTNode visitQuestionWithoutWidget(@NotNull QLSParser.QuestionWithoutWidgetContext ctx) {
        String identifier = ctx.ID().getText();
        return new Question(this.getLineNumber(ctx), identifier, new UndefinedWidget());
    }

    @Override 
	public AbstractASTNode visitWidget(@NotNull QLSParser.WidgetContext ctx) {
		return (Widget) ctx.supportedWidget().accept(this);
	}
    
    @Override 
	public AbstractASTNode visitNoStylesDefaultDeclr(@NotNull QLSParser.NoStylesDefaultDeclrContext ctx) {
        Type questionType = (Type) ctx.type().accept(this);
        Widget widget = (Widget) ctx.widget().accept(this);

        return new DefaultStyleDeclaration(this.getLineNumber(ctx), new UndefinedStyle(), widget, questionType);
    }
    
    @Override 
	public AbstractASTNode visitStylesDefaultDeclr(@NotNull QLSParser.StylesDefaultDeclrContext ctx) {
        Type questionType = (Type) ctx.type().accept(this);
        Widget widget = (Widget) ctx.widget().accept(this);

        List<StyleProperty> styleProperties = new ArrayList<>();
        for (QLSParser.StylePropertyContext stylePropertyContext : ctx.styleProperty()) {
            StyleProperty styleProperty = (StyleProperty) stylePropertyContext.accept(this);
            styleProperties.add(styleProperty);
        }

        Style style = new Style(this.getLineNumber(ctx), styleProperties);

        return new DefaultStyleDeclaration(this.getLineNumber(ctx), style, widget, questionType);
	}
    
    @Override 
	public AbstractASTNode visitCheckboxWidget(@NotNull QLSParser.CheckboxWidgetContext ctx) {
        return new CheckBox(this.getLineNumber(ctx));
	}
    
    @Override 
	public AbstractASTNode visitRadioWidget(@NotNull QLSParser.RadioWidgetContext ctx) {
        String yesLabel = ctx.yes.getText();
        String noLabel = ctx.no.getText();
		return new RadioBtn(this.getLineNumber(ctx), this.removeStringQuotes(yesLabel), this.removeStringQuotes(noLabel));
	}
    
    @Override 
	public AbstractASTNode visitDropdownWidget(@NotNull QLSParser.DropdownWidgetContext ctx) {
        String yesLabel = ctx.yes.getText();
        String noLabel = ctx.no.getText();
        return new Dropdown(this.getLineNumber(ctx), this.removeStringQuotes(yesLabel), this.removeStringQuotes(noLabel));
	}
    
    @Override 
	public AbstractASTNode visitSpinboxWidget(@NotNull QLSParser.SpinboxWidgetContext ctx) {
		return new SpinBox(this.getLineNumber(ctx));
	}
    
    @Override 
	public AbstractASTNode visitSliderWidget(@NotNull QLSParser.SliderWidgetContext ctx) {
		return new Slider(this.getLineNumber(ctx));
	}
    
    @Override 
	public AbstractASTNode visitTextWidget(@NotNull QLSParser.TextWidgetContext ctx) {
		return new TextBox(this.getLineNumber(ctx));
	}
    
    @Override 
	public AbstractASTNode visitWidthStyleProperty(@NotNull QLSParser.WidthStylePropertyContext ctx) {
        IntPropertyType value = new IntPropertyType(
                                        this.getLineNumber(ctx),
                                        Integer.parseInt(
                                                ctx.NUMBER().getText()
                                        ));
		return new Width(this.getLineNumber(ctx), value);
	}
    
    @Override
	public AbstractASTNode visitFontStyleProperty(@NotNull QLSParser.FontStylePropertyContext ctx) {
        StringPropertyType value = new StringPropertyType(
                this.getLineNumber(ctx),
                this.removeStringQuotes(
                        ctx.STRING().getText()
                ));
		return new Font(this.getLineNumber(ctx), value);
	}
    
    @Override 
	public AbstractASTNode visitFontsizeStyleProperty(@NotNull QLSParser.FontsizeStylePropertyContext ctx) {
        IntPropertyType value = new IntPropertyType(
                this.getLineNumber(ctx),
                Integer.parseInt(
                        ctx.NUMBER().getText()
                ));
        return new FontSize(this.getLineNumber(ctx), value);
	}
    
    @Override 
	public AbstractASTNode visitColorStyleProperty(@NotNull QLSParser.ColorStylePropertyContext ctx) {
        StringPropertyType value = new StringPropertyType(
                this.getLineNumber(ctx),
                this.removeStringQuotes(
                        ctx.HEX().getText()
                ));
        return new Color(this.getLineNumber(ctx), value);
	}
    
    @Override 
	public AbstractASTNode visitBoolType(@NotNull QLSParser.BoolTypeContext ctx) {
		return new BoolType(this.getLineNumber(ctx));
	}
    
    @Override 
	public AbstractASTNode visitIntType(@NotNull QLSParser.IntTypeContext ctx) {
        return new IntType(this.getLineNumber(ctx));
	}
    
    @Override 
    public AbstractASTNode visitStringType(@NotNull QLSParser.StringTypeContext ctx) {
        return new StringType(this.getLineNumber(ctx));
	}
}
