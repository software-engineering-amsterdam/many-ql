package parser;

import exceptions.ParseException;
import org.antlr.v4.runtime.misc.NotNull;
import parser.antlrGenerated.QLBaseVisitor;
import parser.antlrGenerated.QLParser;
import parser.ast.nodes.AbstractNode;
import parser.ast.nodes.Form;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class QLBaseVisitorImpl extends QLBaseVisitor<AbstractNode> {
    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        List<AbstractNode> abstractNodes = ctx.statement()
                .stream()
                .map(this::visit)
                .collect(Collectors.toList());
        return new Form(abstractNodes);
    }

    @Override
    public AbstractNode visitStatement(@NotNull QLParser.StatementContext ctx) throws ParseException {
        if (ctx.if_statement() != null) {
            return visit(ctx.if_statement());
        } else if (ctx.question() != null) {
            return visit(ctx.question());
        } else {
            throw new ParseException("Found unknown or invalid Statement entry.");
        }
    }

    @Override
    public AbstractNode visitIf_statement(@NotNull QLParser.If_statementContext ctx) {
        return super.visitIf_statement(ctx);
    }
}
