import lang.ql.ast.AstNode;
import lang.qls.ast.Rule.StylesheetRule;
import lang.qls.ast.Statement.Question;
import lang.qls.ast.Statement.QuestionWithRules;
import lang.qls.ast.Statement.Statement;
import lang.qls.ast.Page;
import lang.qls.ast.Stylesheet;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class QlsBuilder extends QLSBaseVisitor<AstNode>
{
    @Override
    public AstNode visitStylesheet(@NotNull QLSParser.StylesheetContext context)
    {
        List<Page> definitions = new ArrayList<Page>();
        for (QLSParser.PageContext pageContext : context.page())
        {
            Page s = (Page)this.visit(pageContext);
            definitions.add(s);
        }

        String stylesheetId = context.Identifier().getText();
        int lineNumber = context.Identifier().getSymbol().getLine();
        return new Stylesheet(stylesheetId, definitions, lineNumber);
    }

    @Override
    public AstNode visitStatement(@NotNull QLSParser.StatementContext context)
    {
        if (context.section() != null)
        {
            return visitSection(context.section());
        }

        if (context.question() != null)
        {
            return visitQuestion(context.question());
        }

        return visitDefaultStmt(context.defaultStmt());
    }

    @Override
    public AstNode visitPage(@NotNull QLSParser.PageContext context)
    {
        List<Statement> definitions = new ArrayList<Statement>();
        for (QLSParser.StatementContext statementContext : context.statement())
        {
            Statement s = (Statement)this.visit(statementContext);
            definitions.add(s);
        }

        String id = context.Identifier().getText();

        return new Page(id, definitions);
    }

    @Override
    public AstNode visitSection(@NotNull QLSParser.SectionContext context)
    {
        List<Statement> definitions = new ArrayList<Statement>();
        for (QLSParser.StatementContext statementContext : context.statement())
        {
            Statement s = (Statement)this.visit(statementContext);
            definitions.add(s);
        }

        String id = context.String().getText();

        return new Page(id, definitions);
    }

    @Override
    public AstNode visitQuestion(@NotNull QLSParser.QuestionContext context)
    {
        String id = context.Identifier().getText();

        if (context.stylesheetRule() != null)
        {
            List<StylesheetRule> rules = new ArrayList<StylesheetRule>();
            for (QLSParser.StylesheetRuleContext ruleContext : context.stylesheetRule())
            {
                StylesheetRule s = (StylesheetRule)this.visit(ruleContext);
                rules.add(s);
            }

            return new QuestionWithRules(id, rules);
        }

        return new Question(id);
    }

    @Override
    public AstNode visitDefaultStmt(@NotNull QLSParser.DefaultStmtContext ctx)
    {
        return null;
    }

    @Override
    public AstNode visitStylesheetRule(@NotNull QLSParser.StylesheetRuleContext ctx)
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
