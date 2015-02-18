package lang.ql.syntax;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by bore on 09/02/15.
 */
import lang.ql.gen.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class QLVisitorImpl extends QLBaseVisitor<AstNode>
{
    @Override
    public AstNode visitForm(@NotNull QLParser.FormContext context)
    {
        List<Statement> statements = new ArrayList<Statement>();
        for (QLParser.StatementContext statementContext : context.statement())
        {
            Statement s = (Statement)this.visit(statementContext);
            statements.add(s);
        }

        String questionID = context.Identifier().getText();
        return new Form(questionID, statements);
    }

    @Override
    public AstNode visitStatement(@NotNull QLParser.StatementContext context)
    {
        if (context.question() != null)
        {
            return visit(context.question());
        }

        return visit(context.ifCondition());
    }

    @Override
    public AstNode visitQuestion(@NotNull QLParser.QuestionContext context)
    {
        String id = context.Identifier().getText();
        QuestionType questionType = QuestionType.valueOf(context.QuestionType().getText().toUpperCase());
        String text = context.String().getText();

        if (context.expression() != null)
        {
            Expr expr = (Expr)visitExpression(context.expression());
            return new CalculatedQuestion(id, questionType, text, expr);
        }

        return new Question(id, questionType, text);
    }

    @Override
    public AstNode visitIfCondition(@NotNull QLParser.IfConditionContext context)
    {
        Expr expr = (Expr)visitExpression(context.expression());

        List<Statement> ifStatements = new ArrayList<Statement>();
        for (QLParser.StatementContext statement : context.statement())
        {
            Statement s = (Statement)this.visit(statement);
            ifStatements.add(s);
        }

        return new IfCondition(expr, ifStatements);
    }

    @Override
    public AstNode visitExpression(@NotNull QLParser.ExpressionContext context)
    {
        if (context.parenthesis != null)
        {
            return this.visitExpression(context.parenthesis);
        }

        if (context.left != null && context.right != null)
        {
            return this.visitBinaryExpression(context.left, context.right, context.operator.getText());
        }

        if (context.operand != null)
        {
            return this.visitUnaryExpression(context.operand, context.operator.getText());
        }

        return this.visitConstantExpression(context);
    }

    public Expr visitBinaryExpression(QLParser.ExpressionContext lContext, QLParser.ExpressionContext rContext, String operator)
    {
        Expr left = (Expr)this.visit(lContext);
        Expr right = (Expr)this.visit(rContext);

        if (operator.equals("+")) { return new Add(left, right); }
        if (operator.equals("-")) { return new Sub(left, right); }
        if (operator.equals("*")) { return new Mul(left, right); }
        if (operator.equals("/")) { return new Div(left, right); }
        if (operator.equals(">")) { return new Gt(left, right); }
        if (operator.equals("<")) { return new Lt(left, right); }
        if (operator.equals(">=")) { return new GtEqu(left, right); }
        if (operator.equals("<=")) { return new LtEqu(left, right); }
        if (operator.equals("=")) { return new Equ(left, right); }
        if (operator.equals("!=")) { return new NotEqu(left, right); }
        if (operator.equals("&&")) { return new And(left, right); }
        if (operator.equals("||")) { return new Or(left, right); }

        throw new IllegalArgumentException("No such binary operator: " + operator);
    }

    public Expr visitUnaryExpression(QLParser.ExpressionContext operandContext, String operator)
    {
        Expr operand = (Expr)this.visit(operandContext);

        if (operator.equals("+")) { return new Pos(operand); }
        if (operator.equals("-")) { return new Neg(operand); }
        if (operator.equals("!")) { return new Not(operand); }

        throw new IllegalArgumentException("No such unary operator: " + operator);
    }

    public Expr visitConstantExpression(QLParser.ExpressionContext operandContext)
    {
        if (operandContext.Integer() != null)
        {
            int value = Integer.parseInt(operandContext.Integer().getText());
            return new IntExpr(value);
        }

        if (operandContext.String() != null)
        {
            return new StrExpr(operandContext.String().getText());
        }

        if (operandContext.Identifier() != null)
        {
            return new Identifier(operandContext.Identifier().getText());
        }

        if (operandContext.Boolean() != null)
        {
            Boolean value = Boolean.parseBoolean(operandContext.Boolean().getText());
            return new BoolExpr(value);
        }

        if (operandContext.Decimal() != null)
        {
            BigDecimal value = new BigDecimal(operandContext.Decimal().getText());
            return new DecExpr(value);
        }

        // TODO: add date and decimal expressions
        throw new IllegalArgumentException("Illegal constant expression");
    }
}