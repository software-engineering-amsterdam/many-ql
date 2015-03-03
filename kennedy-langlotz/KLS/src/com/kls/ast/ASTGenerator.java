package com.kls.ast;

import com.kls.ast.node.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import parser.KLSBaseVisitor;
import parser.KLSParser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class ASTGenerator extends KLSBaseVisitor<ANode> {

    @Override
    public ANode visitStylesheet(@NotNull KLSParser.StylesheetContext ctx) {
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
    public ANode visitPage(@NotNull KLSParser.PageContext ctx) {
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
    public ANode visitSection(@NotNull KLSParser.SectionContext ctx) {
        List<QuestionNode> questions = new ArrayList<>();
        for (KLSParser.QuestionContext question : ctx.question()){
            QuestionNode questionNode = (QuestionNode) (visitQuestion(question));
            questions.add(questionNode);
        }

        DefaultNode def = (DefaultNode) (visitDefaultStyle(ctx.defaultStyle()));

        return new SectionNode(ctx.title.getText(), questions, def, getLocation(ctx));
    }

    @Override
    public ANode visitQuestion(@NotNull KLSParser.QuestionContext ctx) {
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
        System.err.println("Unknown question context!");
        assert false;
        return null;
    }

    @Override
    public ANode visitDeclaration(@NotNull KLSParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    @Override
    public ANode visitDefaultStyle(@NotNull KLSParser.DefaultStyleContext ctx) {
        return super.visitDefaultStyle(ctx);
    }

    private Location getLocation(ParserRuleContext context){
        Token startToken = context.getStart();
        Token stopToken = context.getStop();
        URI file = null;
        int offset = startToken.getStartIndex();
        int length = startToken.getStopIndex() - startToken.getStartIndex();
        int beginLine = startToken.getLine();
        int beginColumn = startToken.getCharPositionInLine();
        int endLine = stopToken.getLine();
        int endColumn = stopToken.getCharPositionInLine();

        return new Location(file, offset, length, beginLine, beginColumn, endLine, endColumn);
    }
}
