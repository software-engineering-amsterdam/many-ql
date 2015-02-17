package parser;

import org.antlr.v4.runtime.misc.NotNull;
import parser.antlrGenerated.QLBaseVisitor;
import parser.antlrGenerated.QLParser;
import parser.ast.nodes.AbstractNode;
import parser.ast.nodes.Form;
import parser.ast.nodes.Statement;

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
    public Statement visitStatement(@NotNull QLParser.StatementContext ctx) {
//        return super.visitStatement(ctx);
        return new Statement();
    }
}
