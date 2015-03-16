package qls.semantics;

import ql.gui.control.*;
import ql.gui.control.Spinbox;
import ql.gui.segment.RowStyle;
import qls.ast.rule.*;
import qls.ast.rule.widget.*;
import qls.ast.rule.widget.Dropdown;
import qls.ast.rule.widget.Radio;
import qls.ast.rule.widget.Slider;

/**
 * Created by bore on 10/03/15.
 */
public class RulesToGui implements RuleVisitor<Void>, WidgetVisitor<Control>
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
        this.result.setFont(r.getValue());
        return null;
    }

    @Override
    public Void visit(FontSize r)
    {
        this.result.setFontSize(r.getValue());
        return null;
    }

    @Override
    public Void visit(BackColor r)
    {
        this.result.setBackColor(r.getValue().getColor());
        return null;
    }

    @Override
    public Void visit(ForeColor r)
    {
        this.result.setForeColor(r.getValue().getColor());
        return null;
    }

    @Override
    public Void visit(Widget r)
    {
        Control c = r.getValue().accept(this);
        this.result.setWidget(c);
        return null;
    }

    @Override
    public Control visit(Checkbox w)
    {
        return new CheckBox(true, true); //TODO: check these values
    }

    @Override
    public Control visit(Dropdown w)
    {
        return new ql.gui.control.Dropdown(true, true);
    }

    @Override
    public Control visit(Radio w)
    {
        return new Radios(true, true, w.getYesLabel(), w.getNoLabel());
    }

    @Override
    public Control visit(Slider w)
    {
        return new ql.gui.control.Slider(true, true);
    }

    @Override
    public Control visit(qls.ast.rule.widget.Spinbox w)
    {
        return new Spinbox(true, true);
    }

    @Override
    public Control visit(Textbox w)
    {
        return new TextField(true, true);
    }
}
