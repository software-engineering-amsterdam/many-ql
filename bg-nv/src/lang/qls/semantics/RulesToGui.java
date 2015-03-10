package lang.qls.semantics;

import lang.ql.gui.segment.RowStyle;
import lang.qls.ast.rule.*;
import lang.qls.ast.rule.widget.*;

/**
 * Created by bore on 10/03/15.
 */
public class RulesToGui implements RuleVisitor<Void>, WidgetVisitor<Void>
{
    private RowStyle result;

    public static RowStyle convert(Rules rs)
    {
        RulesToGui visitor = new RulesToGui();
        for (Rule r : rs)
        {
            r.accept(visitor);
        }

        return visitor.result;
    }

    private RulesToGui()
    {
        this.result = new RowStyle();
    }

    @Override
    public Void visit(Width r)
    {
        this.result.setWidth(r.getValue());
        return null;
    }

    @Override
    public Void visit(Font r)
    {
        return null;
    }

    @Override
    public Void visit(FontSize r)
    {
        return null;
    }

    @Override
    public Void visit(BackColor r)
    {
        return null;
    }

    @Override
    public Void visit(ForeColor r)
    {
        return null;
    }

    @Override
    public Void visit(Widget r)
    {
        return null;
    }

    @Override
    public Void visit(Checkbox w)
    {
        return null;
    }

    @Override
    public Void visit(Dropdown w)
    {
        return null;
    }

    @Override
    public Void visit(Radio w)
    {
        return null;
    }

    @Override
    public Void visit(Slider w)
    {
        return null;
    }

    @Override
    public Void visit(Spinbox w)
    {
        return null;
    }

    @Override
    public Void visit(Textbox w)
    {
        return null;
    }
}
