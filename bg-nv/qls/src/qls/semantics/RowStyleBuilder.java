package qls.semantics;

import ql.gui.control.*;
import ql.gui.control.Radio;
import ql.gui.control.Spinbox;
import ql.gui.segment.RowStyle;
import qls.ast.rule.*;
import qls.ast.rule.widget.*;
import qls.ast.rule.widget.Dropdown;
import qls.ast.rule.widget.Slider;

/**
 * Created by bore on 10/03/15.
 */
public class RowStyleBuilder implements RuleVisitor<Void>, WidgetVisitor<Control>
{
    private RowStyle rowStyle;

    public static RowStyle build(Rules rs)
    {
        RowStyleBuilder visitor = new RowStyleBuilder();
        for (Rule r : rs)
        {
            r.accept(visitor);
        }

        return visitor.rowStyle;
    }

    private RowStyleBuilder()
    {
        this.rowStyle = new RowStyle();
    }

    @Override
    public Void visit(Width r)
    {
        this.rowStyle.setWidth(r.getValue());
        return null;
    }

    @Override
    public Void visit(Font r)
    {
        this.rowStyle.setFont(r.getValue());
        return null;
    }

    @Override
    public Void visit(FontSize r)
    {
        this.rowStyle.setFontSize(r.getValue());
        return null;
    }

    @Override
    public Void visit(BackColor r)
    {
        this.rowStyle.setBackColor(r.getValue().getColor());
        return null;
    }

    @Override
    public Void visit(ForeColor r)
    {
        this.rowStyle.setForeColor(r.getValue().getColor());
        return null;
    }

    @Override
    public Void visit(Widget r)
    {
        Control c = r.getValue().accept(this);
        this.rowStyle.setWidget(c);
        return null;
    }

    @Override
    public Control visit(Checkbox w)
    {
        return new CheckBox(true, false); //TODO: check these values
    }

    @Override
    public Control visit(Dropdown w)
    {
        return new ql.gui.control.Dropdown(true, false);
    }

    @Override
    public Control visit(qls.ast.rule.widget.Radio w)
    {
        return new Radio(true, false, w.getYesLabel(), w.getNoLabel());
    }

    @Override
    public Control visit(Slider w)
    {
        return new ql.gui.control.Slider(true, false, w.getMin(), w.getMax(), w.getStep());
    }

    @Override
    public Control visit(qls.ast.rule.widget.Spinbox w)
    {
        return new Spinbox(true, false, w.getMin(), w.getMax(), w.getStep());
    }

    @Override
    public Control visit(Textbox w)
    {
        return new TextField(true, false);
    }
}
