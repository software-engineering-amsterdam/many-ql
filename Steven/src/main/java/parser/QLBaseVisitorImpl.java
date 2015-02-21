package parser;

import exceptions.NoSuchType;
import exceptions.ParseException;
import org.antlr.v4.runtime.misc.NotNull;
import parser.antlrGenerated.QLBaseVisitor;
import parser.antlrGenerated.QLParser;
import parser.ast.nodes.*;
import parser.ast.nodes.expression.*;
import parser.ast.nodes.question.Label;
import parser.ast.nodes.question.Question;
import parser.ast.nodes.question.QuestionType;
import parser.ast.nodes.statement.IfStatement;
import parser.ast.nodes.statement.Statement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class QLBaseVisitorImpl extends QLBaseVisitor<AbstractNode> {
    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        List<Statement> statements = collectStatements(ctx.statement());
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
        List<Statement> statements = collectStatements(ctx.statement());
        return new IfStatement(expression, statements);
    }

    @Override
    public AbstractNode visitQuestion(@NotNull QLParser.QuestionContext ctx) {
        QuestionType questionType = (QuestionType) visit(ctx.question_type());
        Identifier identifier = (Identifier) visit(ctx.identifier());
        Label label = (Label) visit(ctx.question_label());
        Optional<Expression> questionExpression = getQuestionExpression(ctx);
        return new Question(identifier, questionType, label, questionExpression);
    }

    private Optional<Expression> getQuestionExpression(QLParser.QuestionContext expressionContext) {
        if (expressionContext.question_expression() != null) {
            Expression expression = (Expression) visitExpression(expressionContext.question_expression().expression());
            return Optional.of(expression);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public AbstractNode visitQuestion_expression(@NotNull QLParser.Question_expressionContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public AbstractNode visitQuestion_label(@NotNull QLParser.Question_labelContext ctx) {
        return new Label(ctx.getText());
    }

    @Override
    public AbstractNode visitIdentifier(@NotNull QLParser.IdentifierContext ctx) {
        return new Identifier(ctx.getText());
    }

    @Override
    public AbstractNode visitQuestion_type(@NotNull QLParser.Question_typeContext ctx) {
        try {
            return QuestionType.getQuestionType(ctx.getText());
        } catch (NoSuchType noSuchType) {
            throw new ParseException(noSuchType.getMessage(), noSuchType);
        }
    }

    @Override
    public AbstractNode visitExpression(@NotNull QLParser.ExpressionContext ctx) {
        if (hasParenthesis(ctx)) {
            return visitExpression(ctx.expression().get(0));
        }

        if (isBinaryOperator(ctx)) {
            return visitBinaryOperator(ctx);
        } else if (isUnaryOperator(ctx)) {
            return visitUnaryOperator(ctx);
        } else if (isIdentifier(ctx)) {
            return new Identifier(ctx.getText());
        } else {
            throw new ParseException("Unknown expression: " + ctx.getText());
        }
    }

    private boolean hasParenthesis(QLParser.ExpressionContext ctx) {
        return (ctx.identifier().isEmpty() || ctx.identifier() == null)
                && ctx.operator() == null
                && ctx.expression() != null
                && !ctx.expression().isEmpty();
    }

    private boolean isIdentifier(QLParser.ExpressionContext ctx) {
        return ctx.identifier() != null;
    }

    private AbstractNode visitBinaryOperator(QLParser.ExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);

        switch (ctx.operator().getText()) {
            case "*":
                return new Multiplication(left, right);
            case "+":
                return new Addition(left, right);
            case "<":
                return new LessThan(left, right);
            case ">":
                return new GreaterThan(left, right);
            case "&&":
                return new And(left, right);
            case "||":
                return new Or(left, right);
            default:
                throw new ParseException("No binary operator for symbol: " + ctx.operator().getText());
        }
    }

    private AbstractNode visitUnaryOperator(QLParser.ExpressionContext ctx) {
        if (ctx.negation != null) {
            return new Not((Expression) visitExpression(ctx.expression(0)));
        } else {
            throw new ParseException("Unknown unary Operator: " + ctx.getText());
        }
    }

    private boolean isUnaryOperator(QLParser.ExpressionContext ctx) {
        return ctx.negation != null;
    }

    private boolean isQuestion(QLParser.StatementContext ctx) {
        return ctx.question() != null;
    }

    private boolean isStatement(QLParser.StatementContext ctx) {
        return ctx.if_statement() != null;
    }

    private boolean isBinaryOperator(QLParser.ExpressionContext ctx) {
        return ctx.operator() != null
                && ctx.left != null
                && ctx.right != null;
    }

    private List<Statement> collectStatements(List<QLParser.StatementContext> statementContexts) {
        return statementContexts
                .stream()
                .map(statementContext -> (Statement) visit(statementContext))
                .collect(Collectors.toList());
    }
}
