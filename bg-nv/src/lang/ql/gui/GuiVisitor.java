package lang.ql.gui;

import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;

/**
 * Created by Nik on 23-2-15.
 */
public interface GuiVisitor<T>
{
    public T visit(Canvas c);

    public T visit(Line line);

    public T visit(Label label);

    public T visit(Input input);
    public T visit(BoolInput input);
    public T visit(DateInput input);
    public T visit(DecInput input);
    public T visit(IntInput input);
    public T visit(StrInput input);
}
