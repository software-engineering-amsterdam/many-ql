package edu.parser.QL;

import com.sun.javaws.exceptions.InvalidArgumentException;
import edu.exceptions.ParseException;
import edu.nodes.QuestionType;
import edu.parser.QL.antlrGenerated.QLBaseVisitor;
import edu.parser.QL.antlrGenerated.QLParser;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.Form;
import edu.parser.QL.nodes.expression.*;
import edu.parser.QL.nodes.question.Label;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.statement.ElseClause;
import edu.parser.QL.nodes.statement.IfStatement;
import edu.parser.QL.nodes.statement.Statement;
import edu.parser.QL.nodes.type.Boolean;
import edu.parser.QL.nodes.type.Number;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class ParseTreeVisitor extends QLBaseVisitor<AbstractNode> {
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
        Optional<ElseClause> elseClause = getElseClause(ctx);
        return new IfStatement(expression, statements, elseClause);
    }

    private Optional<ElseClause> getElseClause(QLParser.If_statementContext ctx) {
        if (ctx.else_clause() != null) {
            return Optional.of((ElseClause) visit(ctx.else_clause()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public AbstractNode visitQuestion(@NotNull QLParser.QuestionContext ctx) {
        QuestionType questionType = (QuestionType) visit(ctx.question_type());
        Identifier identifier = (Identifier) visit(ctx.identifier());
        Label label = (Label) visit(ctx.question_label());
        Optional<Expression> questionExpression = getQuestionExpression(ctx);
        boolean isQuestionEnabled = isQuestionEnabled(questionType);
        return new Question(identifier, questionType, label, isQuestionEnabled, questionExpression);
    }

    private boolean isQuestionEnabled(QuestionType questionType) {
        return !questionType.equals(QuestionType.BOOLEAN);
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
        return new Label(removeQuotesFromString(ctx.getText()));
    }

    private String removeQuotesFromString(String text) {
        return text.substring(1, text.length() - 1);
    }

    @Override
    public AbstractNode visitIdentifier(@NotNull QLParser.IdentifierContext ctx) {
        return new Identifier(ctx.getText());
    }

    @Override
    public AbstractNode visitQuestion_type(@NotNull QLParser.Question_typeContext ctx) {
        try {
            return QuestionType.getType(ctx.getText());
        } catch (InvalidArgumentException e) {
            throw new ParseException("No question type found for: " + ctx.getText());
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
        } else if (isBoolean(ctx)) {
            return visitBoolean(ctx);
        } else if (ctx.numbers != null) {
            return visitNumbers(ctx);
        } else if (isIdentifier(ctx)) {
            return new Identifier(ctx.getText());
        } else {
            throw new ParseException("Unknown expression: " + ctx.getText());
        }
    }

    private AbstractNode visitNumbers(QLParser.ExpressionContext ctx) {
        return new Number(Integer.parseInt(ctx.getText()));
    }

    private boolean isBoolean(QLParser.ExpressionContext ctx) {
        return ctx.booleanExpression() != null;
    }

    private AbstractNode visitBoolean(@NotNull QLParser.ExpressionContext ctx) {
        if (isBoolean(ctx)) {
            return new Boolean(ctx.booleanExpression().isTrue != null);
        } else {
            throw new ParseException("Unknown value for Boolean: " + ctx.getText());
        }
    }

    private boolean hasParenthesis(QLParser.ExpressionContext ctx) {
        return (ctx.leftParenthesis != null && ctx.rightParenthesis != null);
    }

    private boolean isIdentifier(QLParser.ExpressionContext ctx) {
        return ctx.identifier() != null;
    }

    private AbstractNode visitBinaryOperator(QLParser.ExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);

        if (ctx.arithmeticOperator() != null) {
            return visitArithmeticOperator(ctx, left, right);
        } else if (ctx.logicalOperator() != null) {
            return visitLogicalOperator(ctx.logicalOperator(), left, right);
        } else {
            throw new ParseException("No binary operator for symbol: " + ctx.arithmeticOperator().getText());
        }
    }


    private boolean isMultiplication(QLParser.ExpressionContext ctx) {
        return ctx.arithmeticOperator().multiplication != null;
    }

    private boolean isAddition(QLParser.ExpressionContext ctx) {
        return ctx.arithmeticOperator().add != null;
    }

    public AbstractNode visitArithmeticOperator(QLParser.ExpressionContext ctx, Expression left, Expression right) {
        if (isMultiplication(ctx)) {
            return new Multiplication(left, right);
        } else if (isAddition(ctx)) {
            return new Addition(left, right);
        } else {
            throw new ParseException("No arithmetic Operator for input: " + ctx.getText());
        }
    }

    public AbstractNode visitLogicalOperator(@NotNull QLParser.LogicalOperatorContext ctx, Expression left, Expression right) {
        if (isLessThan(ctx)) {
            return new LessThan(left, right);
        } else if (isGreaterThan(ctx)) {
            return new GreaterThan(left, right);
        } else if (isAnd(ctx)) {
            return new And(left, right);
        } else if (isOr(ctx)) {
            return new Or(left, right);
        } else if (isLessOrEqual(ctx)) {
            return new LessOrEqual(left, right);
        } else if (isGreaterOrEqual(ctx)) {
            return new GreaterOrEqual(left, right);
        } else if (isEqual(ctx)) {
            return new Equal(left, right);
        } else if (isNotEqual(ctx)) {
            return new NotEqual(left, right);
        } else {
            throw new ParseException("No Logical Operator for input: " + ctx.getText());
        }
    }

    private boolean isLessThan(QLParser.LogicalOperatorContext ctx) {
        return ctx.lessThan != null;
    }

    private boolean isGreaterThan(QLParser.LogicalOperatorContext ctx) {
        return ctx.greatherThan != null;
    }

    private boolean isAnd(QLParser.LogicalOperatorContext ctx) {
        return ctx.and != null;
    }

    private boolean isOr(QLParser.LogicalOperatorContext ctx) {
        return ctx.or != null;
    }

    private boolean isLessOrEqual(QLParser.LogicalOperatorContext ctx) {
        return ctx.lessOrEqual != null;
    }

    private boolean isGreaterOrEqual(QLParser.LogicalOperatorContext ctx) {
        return ctx.greaterOrEqual != null;
    }

    private boolean isEqual(QLParser.LogicalOperatorContext ctx) {
        return ctx.equal != null;
    }

    private boolean isNotEqual(QLParser.LogicalOperatorContext ctx) {
        return ctx.notEqual != null;
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
        return (ctx.arithmeticOperator() != null || ctx.logicalOperator() != null)
                && ctx.left != null
                && ctx.right != null;
    }

    private List<Statement> collectStatements(List<QLParser.StatementContext> statementContexts) {
        return statementContexts
                .stream()
                .map(statementContext -> (Statement) visit(statementContext))
                .collect(Collectors.toList());
    }

    @Override
    public AbstractNode visitElse_clause(@NotNull QLParser.Else_clauseContext ctx) {
        List<Statement> statements = collectStatements(ctx.statement());
        return new ElseClause(statements);
    }
}
