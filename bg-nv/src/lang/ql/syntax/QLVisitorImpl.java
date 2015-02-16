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
            Expression expression = (Expression)visitExpression(context.expression());
            return new CalculatedQuestion(id, questionType, text, expression);
        }

        return new Question(id, questionType, text);
    }

    @Override
    public AstNode visitIfCondition(@NotNull QLParser.IfConditionContext context)
    {
        Expression expression = (Expression)visitExpression(context.expression());

        List<Statement> ifStatements = new ArrayList<Statement>();
        for (QLParser.StatementContext statement : context.statement())
        {
            Statement s = (Statement)this.visit(statement);
            ifStatements.add(s);
        }

        return new IfCondition(expression, ifStatements);
    }

    @Override
    public AstNode visitExpression(@NotNull QLParser.ExpressionContext context)
    {
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

    public Expression visitBinaryExpression(QLParser.ExpressionContext lContext, QLParser.ExpressionContext rContext, String operator)
    {
        Expression left = (Expression)this.visit(lContext);
        Expression right = (Expression)this.visit(rContext);

        if (operator.equals("+")) { return new AdditionExpression(left, right); }
        if (operator.equals("-")) { return new SubtractionExpression(left, right); }
        if (operator.equals(">")) { return new GreaterThanExpression(left, right); }
        // TODO: add all expressions here
        throw new IllegalArgumentException("No such binary operator: " + operator);
    }

    public Expression visitUnaryExpression(QLParser.ExpressionContext operandContext, String operator)
    {
        Expression operand = (Expression)this.visit(operandContext);

        if (operator == "+") { return new UnaryPlusExpression(operand); }
        if (operator == "-") { return new UnaryMinusExpression(operand); }
        // TODO: add expressions
        throw new IllegalArgumentException("No such unary operator: " + operator);
    }

    public Expression visitConstantExpression(QLParser.ExpressionContext operandContext)
    {
        if (operandContext.Integer() != null)
        {
            int value = Integer.parseInt(operandContext.Integer().getText());
            return new IntegerExpression(value);
        }

        if (operandContext.String() != null)
        {
            return new StringExpression(operandContext.String().getText());
        }

        if (operandContext.Identifier() != null)
        {
            return new VariableExpression(operandContext.Identifier().getText());
        }

        if (operandContext.Boolean() != null)
        {
            Boolean value = Boolean.parseBoolean(operandContext.Boolean().getText());
            return new BooleanExpression(value);
        }

        // TODO: add date and decimal expressions
        throw new IllegalArgumentException("Illegal constant expression");
    }
}