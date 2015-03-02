package edu.parser.QLS;

import edu.parser.QLS.antlrGenerated.QLSBaseVisitor;
import edu.parser.QLS.antlrGenerated.QLSParser;
import edu.parser.AbstractNode;
import edu.parser.QLS.nodes.Stylesheet;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class ParseTreeVisitor extends QLSBaseVisitor<AbstractNode> {
    @Override
    public Stylesheet visitStylesheet(@NotNull QLSParser.StylesheetContext ctx) {
        return null;
    }

    @Override
    public AbstractNode visitStyle(@NotNull QLSParser.StyleContext ctx) {
        return super.visitStyle(ctx);
    }

    @Override
    public AbstractNode visitIdentifier(@NotNull QLSParser.IdentifierContext ctx) {
        return super.visitIdentifier(ctx);
    }

    @Override
    public AbstractNode visitStatement(@NotNull QLSParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public AbstractNode visitDefault_statement(@NotNull QLSParser.Default_statementContext ctx) {
        return super.visitDefault_statement(ctx);
    }

    @Override
    public AbstractNode visitQuestion_type(@NotNull QLSParser.Question_typeContext ctx) {
        return super.visitQuestion_type(ctx);
    }

    @Override
    public AbstractNode visitPage(@NotNull QLSParser.PageContext ctx) {
        return super.visitPage(ctx);
    }

    @Override
    public AbstractNode visitSection(@NotNull QLSParser.SectionContext ctx) {
        return super.visitSection(ctx);
    }

    @Override
    public AbstractNode visitQuestion(@NotNull QLSParser.QuestionContext ctx) {
        return super.visitQuestion(ctx);
    }
}
