package org.fugazi.qls.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.style.UndefinedStyle;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.style_property.*;
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

        StyleSheet styleSheet = new StyleSheet(name, pages);
        styleSheet.setLineNumber(this.getLineNumber(ctx));
        return styleSheet;
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

        Page page = new Page(name, sections, defaultStyles);
        page.setLineNumber(this.getLineNumber(ctx));
        return page;
	}

    @Override 
    public AbstractASTNode visitSection(@NotNull QLSParser.SectionContext ctx) {
        String name = ctx.STRING().getText();

        List<Section> sections = new ArrayList<>();
        for (QLSParser.SectionContext sectionContext : ctx.section()) {
            Section section = (Section) sectionContext.accept(this);
            sections.add(section);
        }

        List<QLSQuestion> questions = new ArrayList<>();
        for (QLSParser.QuestionContext questionContext : ctx.question()) {
            QLSQuestion question = (QLSQuestion) questionContext.accept(this);
            questions.add(question);
        }

        List<DefaultStyleDeclaration> defaultStyles = new ArrayList<>();
        for (QLSParser.DefaultStyleDeclrContext defaultStyleDeclrContext : ctx.defaultStyleDeclr()) {
            DefaultStyleDeclaration defaultStyle = (DefaultStyleDeclaration) defaultStyleDeclrContext.accept(this);
            defaultStyles.add(defaultStyle);
        }

        Section section = new Section(this.removeStringQuotes(name), sections, defaultStyles, questions);
        section.setLineNumber(this.getLineNumber(ctx));
        return section;
	}

    @Override public AbstractASTNode visitQuestionWithWidget(@NotNull QLSParser.QuestionWithWidgetContext ctx) {
        String identifier = ctx.ID().getText();

        AbstractQLSWidget widget = (AbstractQLSWidget) ctx.widget().accept(this);
        widget.setLabel(identifier);

        QLSQuestion qlsQuestion = new QLSQuestion(identifier, widget);
        qlsQuestion.setLineNumber(this.getLineNumber(ctx));
        return qlsQuestion;
    }

    @Override public AbstractASTNode visitQuestionWithoutWidget(@NotNull QLSParser.QuestionWithoutWidgetContext ctx) {
        String identifier = ctx.ID().getText();

        QLSQuestion qlsQuestion = new QLSQuestion(identifier, new QLSUndefinedWidget());
        qlsQuestion.setLineNumber(this.getLineNumber(ctx));
        return qlsQuestion;
    }

    @Override 
	public AbstractASTNode visitWidget(@NotNull QLSParser.WidgetContext ctx) {
		return ctx.supportedWidget().accept(this);
	}
    
    @Override 
	public AbstractASTNode visitNoStylesDefaultDeclr(@NotNull QLSParser.NoStylesDefaultDeclrContext ctx) {
        Type questionType = (Type) ctx.type().accept(this);
        AbstractQLSWidget widget = (AbstractQLSWidget) ctx.widget().accept(this);

        DefaultStyleDeclaration defaultStyleDeclaration =
                new DefaultStyleDeclaration(new UndefinedStyle(), widget.getType(), questionType);
        defaultStyleDeclaration.setLineNumber(this.getLineNumber(ctx));
        return defaultStyleDeclaration;
    }
    
    @Override 
	public AbstractASTNode visitStylesDefaultDeclr(@NotNull QLSParser.StylesDefaultDeclrContext ctx) {
        Type questionType = (Type) ctx.type().accept(this);
        AbstractQLSWidget widget = (AbstractQLSWidget) ctx.widget().accept(this);

        List<StyleProperty> styleProperties = new ArrayList<>();
        for (QLSParser.StylePropertyContext stylePropertyContext : ctx.styleProperty()) {
            StyleProperty styleProperty = (StyleProperty) stylePropertyContext.accept(this);
            styleProperties.add(styleProperty);
        }

        Style style = new Style(styleProperties);
        style.setLineNumber(this.getLineNumber(ctx));

        DefaultStyleDeclaration defaultStyleDeclaration =
                new DefaultStyleDeclaration(style, widget.getType(), questionType);
        defaultStyleDeclaration.setLineNumber(this.getLineNumber(ctx));
        return defaultStyleDeclaration;
	}
    
    @Override 
	public AbstractASTNode visitCheckboxWidget(@NotNull QLSParser.CheckboxWidgetContext ctx) {
        QLSCheckBox widget = new QLSCheckBox();
        widget.setLineNumber(this.getLineNumber(ctx));
        return widget;
	}
    
    @Override 
	public AbstractASTNode visitRadioWidget(@NotNull QLSParser.RadioWidgetContext ctx) {
        String yesLabel = ctx.yes.getText();
        String noLabel = ctx.no.getText();

        QLSRadioBtn widget = new QLSRadioBtn(this.removeStringQuotes(yesLabel), this.removeStringQuotes(noLabel));
        widget.setLineNumber(this.getLineNumber(ctx));
        return widget;
	}
    
    @Override 
	public AbstractASTNode visitDropdownWidget(@NotNull QLSParser.DropdownWidgetContext ctx) {
        String yesLabel = ctx.yes.getText();
        String noLabel = ctx.no.getText();
        QLSDropdown widget = new QLSDropdown(this.removeStringQuotes(yesLabel), this.removeStringQuotes(noLabel));
        widget.setLineNumber(this.getLineNumber(ctx));
        return widget;
	}
    
    @Override 
	public AbstractASTNode visitSpinboxWidget(@NotNull QLSParser.SpinboxWidgetContext ctx) {
        QLSSpinBox widget = new QLSSpinBox();
        widget.setLineNumber(this.getLineNumber(ctx));
        return widget;
	}
    
    @Override 
	public AbstractASTNode visitSliderWidget(@NotNull QLSParser.SliderWidgetContext ctx) {
        QLSSlider widget = new QLSSlider();
        widget.setLineNumber(this.getLineNumber(ctx));
        return widget;
	}
    
    @Override 
	public AbstractASTNode visitTextWidget(@NotNull QLSParser.TextWidgetContext ctx) {
        QLSTextBox widget = new QLSTextBox();
        widget.setLineNumber(this.getLineNumber(ctx));
        return widget;
	}
    
    @Override 
	public AbstractASTNode visitWidthStyleProperty(@NotNull QLSParser.WidthStylePropertyContext ctx) {
        Width styleProperty = new Width(Integer.parseInt(ctx.NUMBER().getText()));
        styleProperty.setLineNumber(this.getLineNumber(ctx));
		return styleProperty;
	}
    
    @Override
	public AbstractASTNode visitFontStyleProperty(@NotNull QLSParser.FontStylePropertyContext ctx) {
        Font styleProperty = new Font(this.removeStringQuotes(ctx.STRING().getText()));
        styleProperty.setLineNumber(this.getLineNumber(ctx));
        return styleProperty;
	}
    
    @Override 
	public AbstractASTNode visitFontsizeStyleProperty(@NotNull QLSParser.FontsizeStylePropertyContext ctx) {
        FontSize styleProperty = new FontSize(Integer.parseInt(ctx.NUMBER().getText()));
        styleProperty.setLineNumber(this.getLineNumber(ctx));
        return styleProperty;
	}
    
    @Override 
	public AbstractASTNode visitColorStyleProperty(@NotNull QLSParser.ColorStylePropertyContext ctx) {
        Color styleProperty = new Color(this.removeStringQuotes(ctx.HEX().getText()));
        styleProperty.setLineNumber(this.getLineNumber(ctx));
        return styleProperty;
	}
    
    @Override 
	public AbstractASTNode visitBoolType(@NotNull QLSParser.BoolTypeContext ctx) {
        BoolType type = new BoolType();
        type.setLineNumber(this.getLineNumber(ctx));
        return type;
	}
    
    @Override 
	public AbstractASTNode visitIntType(@NotNull QLSParser.IntTypeContext ctx) {
        IntType type = new IntType();
        type.setLineNumber(this.getLineNumber(ctx));
        return type;
	}
    
    @Override 
    public AbstractASTNode visitStringType(@NotNull QLSParser.StringTypeContext ctx) {
        StringType type = new StringType();
        type.setLineNumber(this.getLineNumber(ctx));
        return type;
	}
}
