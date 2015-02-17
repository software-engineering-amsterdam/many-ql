package parser;

import exceptions.ParseException;
import org.antlr.v4.runtime.misc.NotNull;
import parser.antlrGenerated.QLBaseVisitor;
import parser.antlrGenerated.QLParser;
import parser.ast.nodes.*;
import parser.ast.nodes.expression.BinaryExpression;
import parser.ast.nodes.expression.Expression;
import parser.ast.nodes.statement.IfStatement;
import parser.ast.nodes.statement.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class QLBaseVisitorImpl extends QLBaseVisitor<AbstractNode> {
    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        List<Statement> statements = collectAllStatements(ctx.statement());
        return new Form(statements);
    }

    @Override
    public AbstractNode visitStatement(@NotNull QLParser.StatementContext ctx) throws ParseException {
        if (isStatement(ctx)) {
            return visit(ctx.if_statement());
        } else if (isQuestion(ctx)) {
            return visit(ctx.question());
        } else {
            throw new ParseException("Found unknown or invalid Statement entry.");
        }
    }

    @Override
    public AbstractNode visitIf_statement(@NotNull QLParser.If_statementContext ctx) {
        Expression expression = (Expression) visit(ctx.expression());
        List<Statement> statements = collectAllStatements(ctx.statement());
        return new IfStatement(expression, statements);
    }

    @Override
    public AbstractNode visitExpression(@NotNull QLParser.ExpressionContext ctx) {
        if (isBinaryOperator(ctx)) {
            visitBinaryOperator(ctx);
        }

        return super.visitExpression(ctx);
    }

    private AbstractNode visitBinaryOperator(QLParser.ExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);

        return new BinaryExpression(left, right);
    }

    private boolean isQuestion(QLParser.StatementContext ctx) {
        return ctx.question() != null;
    }

    private boolean isStatement(QLParser.StatementContext ctx) {
        return ctx.if_statement() != null;
    }

    private boolean isBinaryOperator(QLParser.ExpressionContext ctx) {
        if (ctx.operator() != null) {
            assert ctx.left != null;
            assert ctx.right != null;
            return true;
        } else {
            return false;
        }
    }

    private List<Statement> collectAllStatements(List<QLParser.StatementContext> statementContexts) {
        List<Statement> statements = new ArrayList<>();
        for (QLParser.StatementContext statementContext : statementContexts) {
            statements.add((Statement) visit(statementContext));
        }
        return statements;
    }
}
