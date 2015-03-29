package qls.ast;

import org.antlr.v4.runtime.tree.TerminalNode;
import ql.ast.AstNode;
import ql.ast.type.Type;
import ql.ast.type.TypeFactory;
import ql.util.StringHelper;
import qls.ast.rule.*;
import qls.ast.rule.widget.*;
import qls.ast.statement.*;
import qls.ast.statement.Section;
import qls.gen.QLSBaseVisitor;
import qls.gen.QLSParser;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class AstBuilder extends QLSBaseVisitor<AstNode>
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

        TerminalNode n = context.String();
        String id = StringHelper.unescapeString(n.getText());
        int lineNumber = context.String().getSymbol().getLine();

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

        if (context.defaultStmt() != null)
        {
            return visitDefaultStmt(context.defaultStmt());
        }

        throw new IllegalStateException("Unsupported statement");
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

        String id = StringHelper.unescapeString(context.String().getText());
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
            return new Width(value, lineNumber);
        }

        if (label.equals("backcolor"))
        {
            ColorValue c = new ColorValue(context.Color().getText());
            return new BackColor(c, lineNumber);
        }

        if (label.equals("forecolor"))
        {
            ColorValue c = new ColorValue(context.Color().getText());
            return new ForeColor(c, lineNumber);
        }

        if (label.equals("font"))
        {
            return new Font(StringHelper.unescapeString(context.String().getText()), lineNumber);
        }

        if (label.equals("fontsize"))
        {
            int value = Integer.parseInt(context.Integer().getText());
            return new FontSize(value, lineNumber);
        }

        if (label.equals("widget"))
        {
            WidgetValue value = (WidgetValue)this.visitWidgetValue(context.widgetValue());
            return new Widget(value, lineNumber);
        }

        throw new IllegalStateException("Unsupported stylesheet rule");
    }

    @Override
    public AstNode visitWidgetValue(QLSParser.WidgetValueContext context)
    {
        String label = context.wlabel.getText();

        if (label.equals("slider"))
        {
            if (context.decMin != null)
            {
                BigDecimal min = new BigDecimal(context.decMin.getText());
                BigDecimal max = new BigDecimal(context.decMax.getText());
                BigDecimal step = new BigDecimal(context.decStep.getText());

                return new DecSlider(min, max, step);
            }

            Integer min = Integer.parseInt(context.intMin.getText());
            Integer max = Integer.parseInt(context.intMax.getText());
            Integer step = Integer.parseInt(context.intStep.getText());

            return new IntSlider(min, max, step);
        }

        if (label.equals("radio"))
        {
            String yes = StringHelper.unescapeString(context.yesText.getText());
            String no = StringHelper.unescapeString(context.noText.getText());

            return new Radio(yes, no);
        }

        if (label.equals("dropdown"))
        {
            String yes = StringHelper.unescapeString(context.yesText.getText());
            String no = StringHelper.unescapeString(context.noText.getText());

            return new Dropdown(yes, no);
        }

        if (label.equals("checkbox"))
        {
            return new Checkbox();
        }

        if (label.equals("textbox"))
        {
            return new Textbox();
        }

        throw new IllegalStateException("Unsupported widget value");
    }
}
