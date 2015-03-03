import lang.ql.ast.AstNode;
import lang.ql.ast.type.Type;
import lang.ql.ast.type.TypeFactory;
import lang.qls.ast.Rule.*;
import lang.qls.ast.Rule.Widget.CheckBox;
import lang.qls.ast.Rule.Widget.Radio;
import lang.qls.ast.Rule.Widget.SpinBox;
import lang.qls.ast.Statement.*;
import lang.qls.ast.Page;
import lang.qls.ast.Stylesheet;
import org.antlr.v4.runtime.misc.NotNull;
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
    public AstNode visitPage(@NotNull QLSParser.PageContext context)
    {
        List<Statement> definitions = new ArrayList<Statement>();
        for (QLSParser.StatementContext statementContext : context.statement())
        {
            Statement s = (Statement)this.visit(statementContext);
            definitions.add(s);
        }

        String id = context.Identifier().getText();
        int lineNumber = context.Identifier().getSymbol().getLine();

        return new Page(id, definitions, lineNumber);
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
    public AstNode visitSection(@NotNull QLSParser.SectionContext context)
    {
        List<Statement> definitions = new ArrayList<Statement>();
        for (QLSParser.StatementContext statementContext : context.statement())
        {
            Statement s = (Statement)this.visit(statementContext);
            definitions.add(s);
        }

        String id = context.String().getText();
        int lineNumber = context.String().getSymbol().getLine();

        return new Section(id, definitions, lineNumber);
    }

    @Override
    public AstNode visitQuestion(@NotNull QLSParser.QuestionContext context)
    {
        String id = context.Identifier().getText();
        int lineNumber = context.Identifier().getSymbol().getLine();

        if (context.stylesheetRule() != null)
        {
            List<StylesheetRule> rules = new ArrayList<StylesheetRule>();
            for (QLSParser.StylesheetRuleContext ruleContext : context.stylesheetRule())
            {
                StylesheetRule s = (StylesheetRule)this.visit(ruleContext);
                rules.add(s);
            }

            return new QuestionWithRules(id, lineNumber, rules);
        }

        return new Question(id, lineNumber);
    }

    @Override
    public AstNode visitDefaultStmt(@NotNull QLSParser.DefaultStmtContext context)
    {
        List<StylesheetRule> rules = new ArrayList<StylesheetRule>();
        for (QLSParser.StylesheetRuleContext ruleContext : context.stylesheetRule())
        {
            StylesheetRule s = (StylesheetRule)this.visit(ruleContext);
            rules.add(s);
        }

        Type type = TypeFactory.createType(context.QuestionType().getText());
        int lineNumber = context.QuestionType().getSymbol().getLine();

        return new DefaultStmt(type, rules, lineNumber);
    }

    @Override
    public AstNode visitStylesheetRule(@NotNull QLSParser.StylesheetRuleContext context)
    {
        int lineNumber = context.label.getLine();
        String label = context.label.getText();

        if (label.equals("width"))
        {
            int value = Integer.parseInt(context.Integer().getText());
            return new Width(value, lineNumber);
        }

        if (label.equals("color"))
        {
            return new Color(context.Color().getText(), lineNumber);
        }

        if (label.equals("font"))
        {
            return new Font(context.String().getText(), lineNumber);
        }

        if (label.equals("fontsize"))
        {
            int value = Integer.parseInt(context.Integer().getText());
            return new FontSize(value, lineNumber);
        }

        if (label.equals("widget"))
        {
            return this.visitWidgetRule(context, lineNumber);
        }

        throw new IllegalStateException("No such stylesheet rule");
    }

    public AstNode visitWidgetRule(QLSParser.StylesheetRuleContext context, int lineNumber)
    {
        String widget = context.WidgetType().getText();

        if (widget.equals("spinbox"))
        {
            return new SpinBox(lineNumber);
        }

        if (widget.equals("checkbox"))
        {
            return new CheckBox(lineNumber);
        }

        if (widget.equals("radio"))
        {
            List<String> args = this.getStrArgs(context.stringAgrs().String());
            return new Radio(args, lineNumber);
        }

        throw new IllegalStateException("No such widget rule");
    }

    private List<String> getStrArgs(List<TerminalNode> nodes)
    {
        List<String> r = new ArrayList<String>();
        for (TerminalNode n : nodes)
        {
            r.add(n.getText());
        }

        return r;
    }
}
