package lang.ql.syntax;

import lang.ql.ast.AstNode;
import lang.ql.ast.form.Form;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by bore on 09/02/15.
 */
import lang.ql.gen.*;

import java.util.ArrayList;
import java.util.List;

public class QLVisitorImpl implements QLVisitor<AstNode>
{
    @Override
    public AstNode visitForm(@NotNull QLParser.FormContext ctx)
    {
        List<AstNode> children = new ArrayList<AstNode>();
        for (QLParser.StatementContext stat : ctx.statement())
        {
            children.add(visit(stat));
        }
        return new Form(children);
    }

    @Override
    public AstNode visitStatement(@NotNull QLParser.StatementContext ctx)
    {
        return visit(ctx.ifCondition());
    }

    @Override
    public AstNode visitQuestion(@NotNull QLParser.QuestionContext ctx)
    {
        return null;
    }

    @Override
    public AstNode visitIfCondition(@NotNull QLParser.IfConditionContext ctx)
    {
        return null;
    }

    @Override
    public AstNode visitExpression(@NotNull QLParser.ExpressionContext ctx)
    {
        return null;
    }

    @Override
    public AstNode visit(ParseTree parseTree)
    {
        return null;
    }

    @Override
    public AstNode visitChildren(RuleNode ruleNode)
    {
        return null;
    }

    @Override
    public AstNode visitTerminal(TerminalNode terminalNode)
    {
        return null;
    }

    @Override
    public AstNode visitErrorNode(ErrorNode errorNode)
    {
        return null;
    }
}
//{
//    @Override
//    public AstNode visitForm(@NotNull QLParser.FormContext ctx)
//    {
//        return null;
//    }
//
//    @Override
//    public AstNode visitStatement(@NotNull QLParser.StatementContext ctx)
//    {
//        return null;
//    }
//
//    @Override
//    public AstNode visitQuestion(@NotNull QLParser.QuestionContext ctx)
//    {
//        return null;
//    }
//
//    @Override
//    public AstNode visitIfCondition(@NotNull QLParser.IfConditionContext ctx)
//    {
//        return null;
//    }
//
//    @Override
//    public AstNode visitExpression(@NotNull QLParser.ExpressionContext ctx)
//    {
//        return null;
//    }
//
//    @Override
//    public AstNode visit(ParseTree parseTree)
//    {
//        return null;
//    }
//
//    @Override
//    public AstNode visitChildren(RuleNode ruleNode)
//    {
//        return null;
//    }
//
//    @Override
//    public AstNode visitTerminal(TerminalNode terminalNode)
//    {
//        return null;
//    }
//
//    @Override
//    public AstNode visitErrorNode(ErrorNode errorNode)
//    {
//        return null;
//    }
//}
