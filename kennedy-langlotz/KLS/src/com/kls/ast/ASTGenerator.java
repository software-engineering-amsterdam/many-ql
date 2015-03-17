package com.kls.ast;

import com.common.ast.Location;
import com.klq.logic.question.Type;
import com.kls.ast.node.*;
import com.kls.ast.node.property.*;
import com.kls.ast.node.value.*;
import com.kls.parser.KLSBaseVisitor;
import com.kls.parser.KLSParser;
import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.scene.text.Font;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class ASTGenerator extends KLSBaseVisitor<ANodeBase> {
    private final String inputfile;

    public ASTGenerator(String inputfile) {
        this.inputfile = inputfile;
    }

    @Override
    public ANodeBase visitStylesheet(@NotNull KLSParser.StylesheetContext ctx) {
        StylesheetNode stylesheetNode = new StylesheetNode(getLocation(ctx));

        for (KLSParser.PageContext page : ctx.page()) {
            PageNode pageNode = (PageNode) (visitPage(page));
            stylesheetNode.getGroups().add(pageNode);
        }

        for (KLSParser.SectionContext section : ctx.section()) {
            SectionNode sectionNode = (SectionNode) (visitSection(section));
            stylesheetNode.getGroups().add(sectionNode);
        }

        for (KLSParser.QuestionContext question : ctx.question()) {
            QuestionNode questionNode = (QuestionNode) (visitQuestion(question));
            stylesheetNode.getSelectors().add(questionNode);
        }
        return stylesheetNode;
    }

    @Override
    public ANodeBase visitPage(@NotNull KLSParser.PageContext ctx) {
        List<SectionNode> sections = new ArrayList<>();
        for (KLSParser.SectionContext section : ctx.section()) {
            SectionNode sectionNode = (SectionNode) (visitSection(section));
            sections.add(sectionNode);
        }

        List<QuestionNode> questions = new ArrayList<>();
        for (KLSParser.QuestionContext question : ctx.question()) {
            QuestionNode questionNode = (QuestionNode) (visitQuestion(question));
            questions.add(questionNode);
        }

        DefaultNode def = (DefaultNode) (visitDefaultStyle(ctx.defaultStyle()));

        return new PageNode(ctx.title.getText(), sections, questions, def, getLocation(ctx));
    }

    @Override
    public ANodeBase visitSection(@NotNull KLSParser.SectionContext ctx) {
        List<QuestionNode> questions = new ArrayList<>();
        for (KLSParser.QuestionContext question : ctx.question()) {
            QuestionNode questionNode = (QuestionNode) (visitQuestion(question));
            questions.add(questionNode);
        }

        String title = ctx.title.getText();
        Location location = getLocation(ctx);
        if (ctx.defaultStyle() != null) {
            DefaultNode def = (DefaultNode) (visitDefaultStyle(ctx.defaultStyle()));
            return new SectionNode(title, questions, def, location);
        } else {
            return new SectionNode(title, questions, null, location);
        }
    }

    @Override
    public ANodeBase visitQuestion(@NotNull KLSParser.QuestionContext ctx) {
        List<DeclarationNode> declarations = new ArrayList<>();
        if (ctx.full() != null) {
            for (KLSParser.DeclarationContext declarationContext : ctx.full().declaration()) {
                DeclarationNode declarationNode = (DeclarationNode) (visitDeclaration(declarationContext));
                declarations.add(declarationNode);
            }
            return new QuestionNode(ctx.full().id.getText(), declarations, getLocation(ctx));
        } else if (ctx.identifier() != null) {
            return new QuestionNode(ctx.identifier().id.getText(), declarations, getLocation(ctx));
        }
        throw new IllegalArgumentException("Unknown question context.");
    }

    @Override
    public ANodeBase visitDeclaration(@NotNull KLSParser.DeclarationContext ctx) {
        PropertyNode propertyNode = (PropertyNode) visitProperty(ctx.property());
        ValueNode valueNode = (ValueNode) visitValue(ctx.value());

        /*
        if (propertyNode.getProperty().isCompatibleWith(valueNode.getValue())){
            return new DeclarationNode(propertyNode, valueNode, getLocation(ctx));
        }*/

        return new DeclarationNode(propertyNode, valueNode, getLocation(ctx));
    }

    @Override
    public ANodeBase visitProperty(@NotNull KLSParser.PropertyContext ctx) {
        AProperty property = parseProperty(ctx.getText());
        assert(property != null);
        return new PropertyNode(property, getLocation(ctx));
    }

    private AProperty parseProperty(String property){
        String normalized = property.toLowerCase().trim();
        if (normalized.equals(FontFamilyProperty.FONT_FAMILY)){
            return new FontFamilyProperty();
        } else if (normalized.equals(FontSizeProperty.FONT_SIZE)){
            return new FontSizeProperty();
        } else if (normalized.equals(FontStyleProperty.FONT_STYLE)){
            return new FontStyleProperty();
        } else if (normalized.equals(FontColorProperty.FONT_COLOR)){
            return new FontColorProperty();
        } else if (normalized.equals(BackgroundColorProperty.BACKGROUND_COLOR)){
            return new BackgroundColorProperty();
        } else if (normalized.equals(WidgetProperty.WIDGET)){
            return new WidgetProperty();
        }
        return null;
    }

    @Override
    public ANodeBase visitValue(@NotNull KLSParser.ValueContext ctx) {
        String valueString = ctx.getText();
        AValue value = parseValue(valueString);
        return new ValueNode(value, getLocation(ctx));
    }

    private AValue parseValue(String value) {
        String normalized = value.trim().toLowerCase();

        if (isInt(normalized)) {
            return new FontSizeValue(Integer.parseInt(normalized));
        } else if (isHexColor(normalized)) {
            return new ColorValue(normalized);
        } else if (isWidget(normalized)) {
            return new WidgetValue(getWidgetValue(normalized));
        } else if (isFontStyle(normalized)) {
            return new FontStyleValue(normalized);
        } else {
            return new StringValue(normalized);
        }
    }

    private boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isHexColor(String value) {
        String hexPattern = "#" + "[0-9A-Fa-f]" + "{6}";
        return value.matches(hexPattern);
    }

    private boolean isWidget(String value) {
        return getWidgetValue(value) != WidgetValue.Widget.NOT_A_WIDGET;
    }

    private WidgetValue.Widget getWidgetValue(String value) {
        if (value.equals(WidgetValue.Widget.SLIDER.toString())) {
            return WidgetValue.Widget.SLIDER;
        } else if (value.equals(WidgetValue.Widget.SPINBOX.toString())) {
            return WidgetValue.Widget.SPINBOX;
        } else if (value.equals(WidgetValue.Widget.TEXT.toString())) {
            return WidgetValue.Widget.TEXT;
        } else if (value.equals(WidgetValue.Widget.YES_NO_RADIO.toString())) {
            return WidgetValue.Widget.YES_NO_RADIO;
        } else if (value.equals(WidgetValue.Widget.YES_NO_DROPDOWN.toString())) {
            return WidgetValue.Widget.YES_NO_DROPDOWN;
        } else if (value.equals(WidgetValue.Widget.CHECKBOX.toString())) {
            return WidgetValue.Widget.CHECKBOX;
        }
        return WidgetValue.Widget.NOT_A_WIDGET;
    }

    private boolean isFontStyle(String value) {
        return value.matches(FontStyleValue.FONT_BOLD)
                || value.matches(FontStyleValue.FONT_ITALIC)
                || value.matches(FontStyleValue.FONT_UNDERLINED);
    }

    @Override
    public ANodeBase visitDefaultStyle(@NotNull KLSParser.DefaultStyleContext ctx) {
        List<DeclarationNode> declarations = new ArrayList<>();
        for (KLSParser.DeclarationContext declarationContext : ctx.declaration()){
            DeclarationNode declaration = (DeclarationNode) visitDeclaration(declarationContext);
            declarations.add(declaration);
        }
        Type type = Type.getEnum(ctx.klqType().getText());
        return new DefaultNode(type, declarations, getLocation(ctx));
    }

    private Location getLocation(ParserRuleContext context){
        return new Location(inputfile, context);
    }
}
