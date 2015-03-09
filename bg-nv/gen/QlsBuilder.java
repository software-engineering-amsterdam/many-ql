import lang.ql.ast.AstNode;
import lang.ql.ast.type.Type;
import lang.ql.ast.type.TypeFactory;
import lang.qls.ast.Rule.*;
import lang.qls.ast.Rule.WidgetValue.Checkbox;
import lang.qls.ast.Rule.WidgetValue.Radio;
import lang.qls.ast.Rule.WidgetValue.Spinbox;
import lang.qls.ast.Rule.WidgetValue.WidgetValue;
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
            List<Rule> rules = new ArrayList<Rule>();
            for (QLSParser.StylesheetRuleContext ruleContext : context.stylesheetRule())
            {
                Rule s = (Rule)this.visit(ruleContext);
                rules.add(s);
            }

            return new QuestionWithRules(id, lineNumber, new Rules(rules));
        }

        return new Question(id, lineNumber);
    }

    @Override
    public AstNode visitDefaultStmt(@NotNull QLSParser.DefaultStmtContext context)
    {
        List<Rule> rules = new ArrayList<Rule>();
        for (QLSParser.StylesheetRuleContext ruleContext : context.stylesheetRule())
        {
            Rule s = (Rule)this.visit(ruleContext);
            rules.add(s);
        }

        Type type = TypeFactory.createType(context.QuestionType().getText());
        int lineNumber = context.QuestionType().getSymbol().getLine();

        return new DefaultStat(type, new Rules(rules), lineNumber);
    }

    @Override
    public AstNode visitStylesheetRule(@NotNull QLSParser.StylesheetRuleContext context)
    {
        int lineNumber = context.label.getLine();
        String label = context.label.getText();

        if (label.equals("width"))
        {
            int value = Integer.parseInt(context.Integer().getText());
            return new IntRule("width", value, lineNumber);
        }

        if (label.equals("color"))
        {
            return new StrRule("color", context.Color().getText(), lineNumber);
        }

        if (label.equals("font"))
        {
            return new StrRule("font", context.String().getText(), lineNumber);
        }

        if (label.equals("fontsize"))
        {
            int value = Integer.parseInt(context.Integer().getText());
            return new IntRule("fontsize", value, lineNumber);
        }

        if (label.equals("widget"))
        {
            WidgetValue value = (WidgetValue)this.visitWidgetValue(context.widgetValue());
            return new WidgetRule("widget", value, lineNumber);
        }

        throw new IllegalStateException("No such stylesheet rule");
    }

    @Override
    public AstNode visitWidgetValue(QLSParser.WidgetValueContext context)
    {
        String label = context.label.getText();
        if (label.equals("spinbox"))
        {
            if (context.min != null)
            {
                int min = Integer.parseInt(context.min.getText());
                int max = Integer.parseInt(context.max.getText());

                return new Spinbox(min, max);
            }

            return new Spinbox();
        }

        if (label.equals("checkbox"))
        {
            return new Checkbox();
        }

        if (label.equals("radio"))
        {
            return new Radio(context.yesText.getText(), context.noText.getText());
        }

        throw new IllegalStateException("Unsupported widget value");
    }
}
