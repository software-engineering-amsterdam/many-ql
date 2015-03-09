package com.kls.ast;

import com.common.Location;
import com.klq.logic.question.Type;
import com.kls.ast.node.*;
import com.kls.ast.node.value.AValue;
import com.kls.ast.node.value.StringValue;
import com.kls.parser.KLSBaseVisitor;
import com.kls.parser.KLSParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;

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

        for (KLSParser.PageContext page : ctx.page()){
            PageNode pageNode = (PageNode) (visitPage(page));
            stylesheetNode.getGroups().add(pageNode);
        }

        for (KLSParser.SectionContext section : ctx.section()){
            SectionNode sectionNode = (SectionNode) (visitSection(section));
            stylesheetNode.getGroups().add(sectionNode);
        }

        for (KLSParser.QuestionContext question : ctx.question()){
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
        for (KLSParser.QuestionContext question : ctx.question()){
            QuestionNode questionNode = (QuestionNode) (visitQuestion(question));
            questions.add(questionNode);
        }

        DefaultNode def = (DefaultNode) (visitDefaultStyle(ctx.defaultStyle()));

        return new PageNode(ctx.title.getText(), sections, questions, def, getLocation(ctx));
    }

    @Override
    public ANodeBase visitSection(@NotNull KLSParser.SectionContext ctx) {
        List<QuestionNode> questions = new ArrayList<>();
        for (KLSParser.QuestionContext question : ctx.question()){
            QuestionNode questionNode = (QuestionNode) (visitQuestion(question));
            questions.add(questionNode);
        }

        String title = ctx.title.getText();
        Location location = getLocation(ctx);
        if (ctx.defaultStyle() != null){
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

        return new DeclarationNode(propertyNode, valueNode, getLocation(ctx));
    }

    @Override
    public ANodeBase visitProperty(@NotNull KLSParser.PropertyContext ctx) {
        PropertyNode.Property property = PropertyNode.Property.getEnum(ctx.getText());
        return new PropertyNode(property, getLocation(ctx));
    }

    @Override
    public ANodeBase visitValue(@NotNull KLSParser.ValueContext ctx) {
        AValue value = new StringValue(ctx.getText());
        return new ValueNode(value, getLocation(ctx));
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
        Token tokenStart = context.getStart();
        Token tokenEnd = context.getStop();
        int offset = tokenStart.getStartIndex();
        int length = tokenStart.getStopIndex() - tokenStart.getStartIndex();
        int beginLine = tokenStart.getLine();
        int beginColumn = tokenStart.getCharPositionInLine();
        int endLine = tokenEnd.getLine();
        int endColumn = tokenEnd.getCharPositionInLine();

        return new Location(inputfile, offset, length, beginLine, beginColumn, endLine, endColumn);
    }
}
