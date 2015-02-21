package nl.uva.softwcons.ast;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.AdditionExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.DivisionExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.MultiplicationExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.SubtractionExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.EqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterOrEqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterThanExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerOrEqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerThanExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.NotEqualExpression;
import nl.uva.softwcons.ast.expression.binary.logical.AndExpression;
import nl.uva.softwcons.ast.expression.binary.logical.OrExpression;
import nl.uva.softwcons.ast.expression.identifier.IdentifierExpression;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.expression.unary.UnaryExpression;
import nl.uva.softwcons.ast.expression.unary.logical.NotExpression;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.statement.Block;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.Statement;
import nl.uva.softwcons.ast.type.Type;
import nl.uva.softwcons.generated.QLBaseVisitor;
import nl.uva.softwcons.generated.QLParser.BinaryExprContext;
import nl.uva.softwcons.generated.QLParser.BooleanContext;
import nl.uva.softwcons.generated.QLParser.ComputedQuestionContext;
import nl.uva.softwcons.generated.QLParser.ConditionalContext;
import nl.uva.softwcons.generated.QLParser.DecimalContext;
import nl.uva.softwcons.generated.QLParser.FormContext;
import nl.uva.softwcons.generated.QLParser.IdContext;
import nl.uva.softwcons.generated.QLParser.IntegerContext;
import nl.uva.softwcons.generated.QLParser.NotExprContext;
import nl.uva.softwcons.generated.QLParser.ParenthesisContext;
import nl.uva.softwcons.generated.QLParser.SimpleQuestionContext;
import nl.uva.softwcons.generated.QLParser.StringContext;
import nl.uva.softwcons.generated.QLParser.TypeContext;
import nl.uva.softwcons.util.Utils;

public class ASTBuilderVisitor extends QLBaseVisitor<ASTNode> {

    @Override
    public Form visitForm(FormContext ctx) {
        final String formName = ctx.ID().getText();
        final List<Statement> statements = ctx.statement().stream().map(st -> (Statement) st.accept(this))
                .collect(Collectors.toList());

        return new Form(formName, new Block(statements));
    }

    @Override
    public Question visitSimpleQuestion(SimpleQuestionContext ctx) {
        final String id = ctx.ID().getText();
        final String label = Utils.unquote(ctx.STRING().getText());
        final Type type = (Type) ctx.type().accept(this);

        return new Question(id, label, type);
    }

    @Override
    public ComputedQuestion visitComputedQuestion(ComputedQuestionContext ctx) {
        final String id = ctx.ID().getText();
        final String label = Utils.unquote(ctx.STRING().getText());
        final Type type = (Type) ctx.type().accept(this);
        final Expression value = (Expression) ctx.expr().accept(this);

        return new ComputedQuestion(id, label, type, value);
    }

    @Override
    public Conditional visitConditional(ConditionalContext ctx) {
        final Expression condition = (Expression) ctx.expr().accept(this);
        final List<Question> questions = ctx.question().stream().map(q -> (Question) q.accept(this))
                .collect(Collectors.toList());

        return new Conditional(condition, questions);
    }

    @Override
    public Type visitType(TypeContext ctx) {
        return Type.valueOf(ctx.getText().toUpperCase(Locale.ENGLISH));
    }

    @Override
    public BinaryExpression visitBinaryExpr(BinaryExprContext ctx) {
        final Expression leftExpression = (Expression) ctx.expr(0).accept(this);
        final Expression rightExpression = (Expression) ctx.expr(1).accept(this);

        switch (ctx.op.getText()) {
        case "*":
            return new MultiplicationExpression(leftExpression, rightExpression);
        case "/":
            return new DivisionExpression(leftExpression, rightExpression);
        case "-":
            return new SubtractionExpression(leftExpression, rightExpression);
        case "+":
            return new AdditionExpression(leftExpression, rightExpression);
        case "&&":
            return new AndExpression(leftExpression, rightExpression);
        case "||":
            return new OrExpression(leftExpression, rightExpression);
        case "<":
            return new LowerThanExpression(leftExpression, rightExpression);
        case "<=":
            return new LowerOrEqualExpression(leftExpression, rightExpression);
        case "==":
            return new EqualExpression(leftExpression, rightExpression);
        case "!=":
            return new NotEqualExpression(leftExpression, rightExpression);
        case ">=":
            return new GreaterOrEqualExpression(leftExpression, rightExpression);
        case ">":
            return new GreaterThanExpression(leftExpression, rightExpression);
        default:
            throw new IllegalArgumentException("Unsupported operator in expression.");
        }
    }

    @Override
    public UnaryExpression visitNotExpr(NotExprContext ctx) {
        return new NotExpression((Expression) ctx.expr().accept(this));
    }

    @Override
    public Expression visitParenthesis(ParenthesisContext ctx) {
        return (Expression) ctx.expr().accept(this);
    }

    @Override
    public BooleanLiteral visitBoolean(BooleanContext ctx) {
        return new BooleanLiteral(Boolean.valueOf(ctx.BOOLEAN().getText()));
    }

    @Override
    public IntegerLiteral visitInteger(IntegerContext ctx) {
        return new IntegerLiteral(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public StringLiteral visitString(StringContext ctx) {
        return new StringLiteral(Utils.unquote(ctx.STRING().getText()));
    }

    @Override
    public ASTNode visitDecimal(DecimalContext ctx) {
        return new DecimalLiteral(new BigDecimal(ctx.DECIMAL().getText()));
    }

    @Override
    public IdentifierExpression visitId(IdContext ctx) {
        return new IdentifierExpression(ctx.ID().getText());
    }
}
