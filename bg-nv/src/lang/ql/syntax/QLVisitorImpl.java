package lang.ql.syntax;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.Expression;
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
            // omg!
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
//        if (context.expression() != null)
//        {
//            AstNode a = visitExpression(context.expression());
//        }

        String id = context.Identifier().getText();
        //Handle exception
        QuestionType questionType = QuestionType.valueOf(context.QuestionType().getText());
        String text = context.String().getText();

        return new Question(id, questionType, text, null);
    }
//
    @Override
    public AstNode visitIfCondition(@NotNull QLParser.IfConditionContext context)
    {
        // omg again!
        Expression expression = (Expression)visitExpression(context.expression());

        List<Statement> ifStatements = new ArrayList<Statement>();
        for (QLParser.StatementContext stat : context.statement())
        {
            Statement s = (Statement)this.visit(stat);
            ifStatements.add(s);
        }

        return new IfCondition(expression, ifStatements);
    }
//
//    @Override
//    public AstNode visitExpression(@NotNull QLParser.ExpressionContext ctx)
//    {
//        return null;
//    }
}