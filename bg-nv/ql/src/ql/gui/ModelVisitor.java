package ql.gui;

import ql.gui.canvas.Canvas;
import ql.gui.control.*;
import ql.gui.input.*;
import ql.gui.label.Label;
import ql.gui.segment.Row;
import ql.gui.segment.Page;
import ql.gui.segment.Section;

/**
 * Created by Nik on 23-2-15.
 */
public interface ModelVisitor<T>
{
    public T visit(Canvas c);

    public T visit(Page page);
    public T visit(Row section);
    public T visit(Section section);

    public T visit(Label label);

    public T visit(BoolInput input);
    public T visit(DateInput input);
    public T visit(DecInput input);
    public T visit(IntInput input);
    public T visit(StrInput input);

    public T visit(ExprInput input);

    public T visit(TextField control);
    public T visit(CheckBox control);
    public T visit(Radio control);
    public T visit(Slider control);
    public T visit(Spinbox control);
    public T visit(Dropdown control);
}
