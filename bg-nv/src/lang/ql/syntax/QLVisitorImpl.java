package lang.ql.syntax;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.AdditionExpression;
import lang.ql.ast.expression.Expression;
import lang.ql.ast.expression.SubtractionExpression;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;
import lang.ql.ast.statement.QuestionType;
import lang.ql.ast.statement.Statement;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by bore on 09/02/15.
 */
import lang.ql.gen.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
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
        // TODO: could the if be avoided?
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
        // TODO: Handle exception of QuestionType conversion
        QuestionType questionType = QuestionType.valueOf(context.QuestionType().getText().toUpperCase());
        String text = context.String().getText();

        if (context.expression() != null)
        {
            Expression expression = (Expression)visitExpression(context.expression());
            return new Question(id, questionType, text, expression);
        }
        // TODO: May be have two Question classes, one with and one without expression?
        return new Question(id, questionType, text, null);
    }

    @Override
    public AstNode visitIfCondition(@NotNull QLParser.IfConditionContext context)
    {
        Expression expression = (Expression)visitExpression(context.expression());

        List<Statement> ifStatements = new ArrayList<Statement>();
        for (QLParser.StatementContext stat : context.statement())
        {
            Statement s = (Statement)this.visit(stat);
            ifStatements.add(s);
        }

        return new IfCondition(expression, ifStatements);
    }

    @Override
    public AstNode visitExpression(@NotNull QLParser.ExpressionContext context)
    {
        if (context.left != null && context.right != null)
        {
            Expression left = (Expression)this.visit(context.left);
            Expression right = (Expression)this.visit(context.right);

            String operator = context.operator.getText();
            if (operator == "+") { return new AdditionExpression(left, right); }
            else if (operator == "-") { return new SubtractionExpression(left, right); }
            else {}
        }
        else if (context.operand != null)
        {

        }
        return null;
    }
}