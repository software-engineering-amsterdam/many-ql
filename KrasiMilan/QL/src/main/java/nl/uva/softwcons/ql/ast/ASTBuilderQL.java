package nl.uva.softwcons.ql.ast;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import static nl.uva.softwcons.ql.ast.type.DateType.DATE_TYPE;
import static nl.uva.softwcons.ql.ast.type.NumberType.NUMBER_TYPE;
import static nl.uva.softwcons.ql.ast.type.StringType.STRING_TYPE;
import static nl.uva.softwcons.ql.ast.type.UndefinedType.UNDEFINED_TYPE;

import java.util.List;
import java.util.stream.Collectors;

import nl.uva.softwcons.generated.QLBaseVisitor;
import nl.uva.softwcons.generated.QLParser.AddSubExprContext;
import nl.uva.softwcons.generated.QLParser.AndExprContext;
import nl.uva.softwcons.generated.QLParser.BooleanContext;
import nl.uva.softwcons.generated.QLParser.ComparisonExprContext;
import nl.uva.softwcons.generated.QLParser.ComputedQuestionContext;
import nl.uva.softwcons.generated.QLParser.ConditionalContext;
import nl.uva.softwcons.generated.QLParser.FormContext;
import nl.uva.softwcons.generated.QLParser.IdContext;
import nl.uva.softwcons.generated.QLParser.MulDivExprContext;
import nl.uva.softwcons.generated.QLParser.NotExprContext;
import nl.uva.softwcons.generated.QLParser.NumberContext;
import nl.uva.softwcons.generated.QLParser.OrExprContext;
import nl.uva.softwcons.generated.QLParser.ParenthesisContext;
import nl.uva.softwcons.generated.QLParser.SimpleQuestionContext;
import nl.uva.softwcons.generated.QLParser.StringContext;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.Equal;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.GreaterThan;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.LowerOrEqual;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.LowerThan;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.NotEqual;
import nl.uva.softwcons.ql.ast.expression.binary.logical.And;
import nl.uva.softwcons.ql.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ql.ast.expression.literal.NumberLiteral;
import nl.uva.softwcons.ql.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ql.ast.expression.unary.logical.Not;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.Statement;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.ql.util.Utils;

import org.antlr.v4.runtime.Token;

public class ASTBuilderQL extends QLBaseVisitor<ASTNode> {

    @Override
    public Form visitForm(final FormContext ctx) {
        final Identifier id = new Identifier(ctx.ID().getText(), extractLineInfo(ctx.ID().getSymbol()));
        final List<Statement> statements = ctx.statement().stream().map(st -> (Statement) st.accept(this))
                .collect(Collectors.toList());

        return new Form(id, statements);
    }

    @Override
    public Question visitSimpleQuestion(final SimpleQuestionContext ctx) {
        final Identifier id = new Identifier(ctx.ID().getText(), extractLineInfo(ctx.ID().getSymbol()));
        final String label = Utils.unquote(ctx.STRING().getText());
        final Type type = getType(ctx.type().getText());

        return new Question(id, label, type);
    }

    @Override
    public ComputedQuestion visitComputedQuestion(final ComputedQuestionContext ctx) {
        final Identifier id = new Identifier(ctx.ID().getText(), extractLineInfo(ctx.ID().getSymbol()));
        final String label = Utils.unquote(ctx.STRING().getText());
        final Type type = getType(ctx.type().getText());
        final Expression value = (Expression) ctx.expr().accept(this);

        return new ComputedQuestion(id, label, type, value);
    }

    @Override
    public Conditional visitConditional(final ConditionalContext ctx) {
        final Expression condition = (Expression) ctx.expr().accept(this);
        final List<Question> questions = ctx.question().stream().map(q -> (Question) q.accept(this))
                .collect(Collectors.toList());

        return new Conditional(condition, questions);
    }

    @Override
    public BinaryExpression visitMulDivExpr(final MulDivExprContext ctx) {
        final Expression leftExpression = (Expression) ctx.expr(0).accept(this);
        final Expression rightExpression = (Expression) ctx.expr(1).accept(this);

        switch (ctx.op.getText()) {
        case "*":
            return new Multiplication(leftExpression, rightExpression, extractLineInfo(ctx.op));
        case "/":
            return new Division(leftExpression, rightExpression, extractLineInfo(ctx.op));
        default:
            throw new IllegalArgumentException("Unsupported operator in expression.");
        }
    }

    @Override
    public ASTNode visitAddSubExpr(final AddSubExprContext ctx) {
        final Expression leftExpression = (Expression) ctx.expr(0).accept(this);
        final Expression rightExpression = (Expression) ctx.expr(1).accept(this);

        switch (ctx.op.getText()) {
        case "-":
            return new Subtraction(leftExpression, rightExpression, extractLineInfo(ctx.op));
        case "+":
            return new Addition(leftExpression, rightExpression, extractLineInfo(ctx.op));

        default:
            throw new IllegalArgumentException("Unsupported operator in expression.");
        }
    }

    @Override
    public ASTNode visitComparisonExpr(final ComparisonExprContext ctx) {
        final Expression leftExpression = (Expression) ctx.expr(0).accept(this);
        final Expression rightExpression = (Expression) ctx.expr(1).accept(this);

        switch (ctx.op.getText()) {
        case "<":
            return new LowerThan(leftExpression, rightExpression, extractLineInfo(ctx.op));
        case "<=":
            return new LowerOrEqual(leftExpression, rightExpression, extractLineInfo(ctx.op));
        case "==":
            return new Equal(leftExpression, rightExpression, extractLineInfo(ctx.op));
        case "!=":
            return new NotEqual(leftExpression, rightExpression, extractLineInfo(ctx.op));
        case ">=":
            return new GreaterOrEqual(leftExpression, rightExpression, extractLineInfo(ctx.op));
        case ">":
            return new GreaterThan(leftExpression, rightExpression, extractLineInfo(ctx.op));
        default:
            throw new IllegalArgumentException("Unsupported operator in expression.");
        }
    }

    @Override
    public And visitAndExpr(final AndExprContext ctx) {
        final Expression leftExpression = (Expression) ctx.expr(0).accept(this);
        final Expression rightExpression = (Expression) ctx.expr(1).accept(this);
        return new And(leftExpression, rightExpression, extractLineInfo(ctx.AND().getSymbol()));
    }

    @Override
    public Or visitOrExpr(final OrExprContext ctx) {
        final Expression leftExpression = (Expression) ctx.expr(0).accept(this);
        final Expression rightExpression = (Expression) ctx.expr(1).accept(this);
        return new Or(leftExpression, rightExpression, extractLineInfo(ctx.OR().getSymbol()));
    }

    @Override
    public Not visitNotExpr(final NotExprContext ctx) {
        return new Not((Expression) ctx.expr().accept(this), extractLineInfo(ctx.NOT().getSymbol()));
    }

    @Override
    public Expression visitParenthesis(final ParenthesisContext ctx) {
        return (Expression) ctx.expr().accept(this);
    }

    @Override
    public BooleanLiteral visitBoolean(final BooleanContext ctx) {
        return new BooleanLiteral(Boolean.valueOf(ctx.BOOLEAN().getText()), extractLineInfo(ctx.BOOLEAN().getSymbol()));
    }

    @Override
    public StringLiteral visitString(final StringContext ctx) {
        return new StringLiteral(Utils.unquote(ctx.STRING().getText()), extractLineInfo(ctx.STRING().getSymbol()));
    }

    @Override
    public ASTNode visitNumber(final NumberContext ctx) {
        return new NumberLiteral(Double.valueOf(ctx.NUMBER().getText()), extractLineInfo(ctx.NUMBER().getSymbol()));
    }

    @Override
    public Identifier visitId(final IdContext ctx) {
        return new Identifier(ctx.ID().getText(), extractLineInfo(ctx.ID().getSymbol()));
    }

    public static LineInfo extractLineInfo(final Token token) {
        return new LineInfo(token.getLine(), token.getCharPositionInLine());
    }

    public static Type getType(final String typeName) {
        switch (typeName) {

        case "boolean":
            return BOOLEAN_TYPE;
        case "number":
            return NUMBER_TYPE;
        case "date":
            return DATE_TYPE;
        case "string":
            return STRING_TYPE;
        default:
            return UNDEFINED_TYPE;
        }
    }
}
