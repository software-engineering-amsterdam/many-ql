package lang.ql.syntax;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.ast.types.Type;
import lang.ql.ast.types.TypeFactory;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by bore on 09/02/15.
 */
import lang.ql.gen.*;

import java.math.BigDecimal;
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
        int lineNumber = context.Identifier().getSymbol().getLine();
        return new Form(questionID, statements, lineNumber);
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
        Type questionType = TypeFactory.createType(context.QuestionType().getText());
        String text = unescapedString(context.String().getText());
        int lineNumber = context.Identifier().getSymbol().getLine();

        if (context.expression() != null)
        {
            Expr expr = (Expr)visitExpression(context.expression());
            return new CalculatedQuestion(id, questionType, text, lineNumber, expr);
        }

        return new Question(id, questionType, text, lineNumber);
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

        int lineNumber = context.getStart().getLine();
        return new IfCondition(expr, ifStatements, lineNumber);
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
        int lineNumber = lContext.getStart().getLine();

        if (operator.equals("+")) { return new Add(left, right, lineNumber); }
        if (operator.equals("-")) { return new Sub(left, right, lineNumber); }
        if (operator.equals("*")) { return new Mul(left, right, lineNumber); }
        if (operator.equals("/")) { return new Div(left, right, lineNumber); }
        if (operator.equals(">")) { return new Gt(left, right, lineNumber); }
        if (operator.equals("<")) { return new Lt(left, right, lineNumber); }
        if (operator.equals(">=")) { return new GtEqu(left, right, lineNumber); }
        if (operator.equals("<=")) { return new LtEqu(left, right, lineNumber); }
        if (operator.equals("==")) { return new Equ(left, right, lineNumber); }
        if (operator.equals("!=")) { return new NotEqu(left, right, lineNumber); }
        if (operator.equals("&&")) { return new And(left, right, lineNumber); }
        if (operator.equals("||")) { return new Or(left, right, lineNumber); }

        throw new IllegalArgumentException("No such binary operator: " + operator);
    }

    public Expr visitUnaryExpression(QLParser.ExpressionContext operandContext, String operator)
    {
        Expr operand = (Expr)this.visit(operandContext);
        int lineNumber = operandContext.getStart().getLine();

        if (operator.equals("+")) { return new Pos(operand, lineNumber); }
        if (operator.equals("-")) { return new Neg(operand, lineNumber); }
        if (operator.equals("!")) { return new Not(operand, lineNumber); }

        throw new IllegalArgumentException("No such unary operator: " + operator);
    }

    public Expr visitConstantExpression(QLParser.ExpressionContext operandContext)
    {
        int lineNumber = operandContext.getStart().getLine();

        if (operandContext.Integer() != null)
        {
            int value = Integer.parseInt(operandContext.Integer().getText());
            return new IntExpr(value, lineNumber);
        }

        if (operandContext.String() != null)
        {
            String s = unescapedString(operandContext.String().getText());
            return new StrExpr(s, lineNumber);
        }

        if (operandContext.Identifier() != null)
        {
            return new Indent(operandContext.Identifier().getText(), lineNumber);
        }

        if (operandContext.Boolean() != null)
        {
            Boolean value = Boolean.parseBoolean(operandContext.Boolean().getText());
            return new BoolExpr(value, lineNumber);
        }

        if (operandContext.Decimal() != null)
        {
            BigDecimal value = new BigDecimal(operandContext.Decimal().getText());
            return new DecExpr(value, lineNumber);
        }

        throw new IllegalArgumentException("Illegal constant expression");
    }

    private String unescapedString(String s)
    {
        String result = s.substring(1, s.length()-1);
        String[] quotes = new String[] {"\"", "“", "”", "'"};

        for (String q : quotes)
        {
            result = result.replace("\\" + q, q);
        }

        return result;
    }
}