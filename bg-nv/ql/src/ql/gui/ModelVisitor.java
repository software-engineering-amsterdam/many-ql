package ql.gui;

import ql.gui.canvas.Canvas;
import ql.gui.control.CheckBox;
import ql.gui.control.Radios;
import ql.gui.control.TextField;
import ql.gui.input.expression.*;
import ql.gui.input.regular.*;
import ql.gui.label.Label;
import ql.gui.segment.Conditional;
import ql.gui.segment.Row;
import ql.gui.segment.Page;

/**
 * Created by Nik on 23-2-15.
 */
public interface ModelVisitor<T>
{
    public T visit(Canvas c);

    public T visit(Page page);
    public T visit(Conditional section);
    public T visit(Row row);

    public T visit(Label label);

    public T visit(BoolInput input);
    public T visit(DateInput input);
    public T visit(DecInput input);
    public T visit(IntInput input);
    public T visit(StrInput input);

    public T visit(BoolExprInput input);
    public T visit(DateExprInput input);
    public T visit(DecExprInput input);
    public T visit(IntExprInput input);
    public T visit(StrExprInput input);

    public T visit(TextField control);
    public T visit(CheckBox control);
    public T visit(Radios control);
}
