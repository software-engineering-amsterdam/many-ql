package edu.parser.QL;

import com.sun.javaws.exceptions.InvalidArgumentException;
import edu.exceptions.ParseException;
import edu.gui.components.store.DefaultStore;
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
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class ParseTreeVisitor extends QLBaseVisitor<AbstractNode> {
    @Override
    public AbstractNode visitBooleanExpression(@NotNull QLParser.BooleanExpressionContext ctx) {
        return new Boolean(ctx.isTrue != null);
    }

    @Override
    public AbstractNode visitGreaterOrEqual(@NotNull QLParser.GreaterOrEqualContext ctx) {
        return new GreaterOrEqual((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitNumbersLabel(@NotNull QLParser.NumbersLabelContext ctx) {
        String number = ctx.numbers.getText();
        return new edu.parser.QL.nodes.type.Number(Integer.parseInt(number));
    }

    @Override
    public AbstractNode visitLessOrEqual(@NotNull QLParser.LessOrEqualContext ctx) {
        return new LessOrEqual((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitSubtraction(@NotNull QLParser.SubtractionContext ctx) {
        return new Subtraction((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitNotEqual(@NotNull QLParser.NotEqualContext ctx) {
        return new NotEqual((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitDivision(@NotNull QLParser.DivisionContext ctx) {
        return new Division((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitEqual(@NotNull QLParser.EqualContext ctx) {
        return new Equal((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitLessThan(@NotNull QLParser.LessThanContext ctx) {
        return new LessThan((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitMultiplication(@NotNull QLParser.MultiplicationContext ctx) {
        return new Multiplication((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitAddition(@NotNull QLParser.AdditionContext ctx) {
        return new Addition((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitGreaterThan(@NotNull QLParser.GreaterThanContext ctx) {
        return new GreaterThan((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitNegationLabel(@NotNull QLParser.NegationLabelContext ctx) {
        Expression expression = (Expression) ctx.expression().accept(this);
        return new Not(expression);
    }

    @Override
    public AbstractNode visitOr(@NotNull QLParser.OrContext ctx) {
        return new Or((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitAnd(@NotNull QLParser.AndContext ctx) {
        return new And((Expression) ctx.left.accept(this), (Expression) ctx.right.accept(this));
    }

    @Override
    public AbstractNode visitIdentifierLabel(@NotNull QLParser.IdentifierLabelContext ctx) {
        return ctx.identifier().accept(this);
    }

    @Override
    public AbstractNode visitParenthesis(@NotNull QLParser.ParenthesisContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public AbstractNode visitBooleanExpressionLabel(@NotNull QLParser.BooleanExpressionLabelContext ctx) {
        return ctx.booleanExpression().accept(this);
    }

    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        List<Statement> statements = collectStatements(ctx.statement());
        return new Form(statements);
    }

    @Override
    public AbstractNode visitQuestionLabel(@NotNull QLParser.QuestionLabelContext ctx) {
        return ctx.question().accept(this);
    }

    @Override
    public AbstractNode visitIf_statementLabel(@NotNull QLParser.If_statementLabelContext ctx) {
        return ctx.if_statement().accept(this);
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
        QLIdentifier QLIdentifier = (QLIdentifier) visit(ctx.identifier());
        Label label = (Label) visit(ctx.question_label());
        Optional<Expression> questionExpression = getQuestionExpression(ctx);
        boolean isQuestionEnabled = isQuestionEnabled(questionType);
        return new Question(QLIdentifier, questionType, label, isQuestionEnabled, questionExpression, Collections.emptyList(), new DefaultStore());
    }

    private boolean isQuestionEnabled(QuestionType questionType) {
        return !questionType.equals(QuestionType.BOOLEAN);
    }

    private Optional<Expression> getQuestionExpression(QLParser.QuestionContext expressionContext) {
        if (expressionContext.question_expression() != null) {
            Expression expression = (Expression) expressionContext.question_expression().accept(this);
            return Optional.of(expression);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public AbstractNode visitQuestion_expression(@NotNull QLParser.Question_expressionContext ctx) {
        return ctx.expression().accept(this);
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
        return new QLIdentifier(ctx.getText());
    }

    @Override
    public AbstractNode visitQuestion_type(@NotNull QLParser.Question_typeContext ctx) {
        try {
            return QuestionType.getType(ctx.getText());
        } catch (InvalidArgumentException e) {
            throw new ParseException("No question type found for: " + ctx.getText());
        }
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
