package lang.ql.gui;

import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;

/**
 * Created by Nik on 23-2-15.
 */
public interface GuiVisitor
{
    public void visit(Canvas c);
    public void visit(Line line);
    public void visit(Input input);
    public void visit(BoolInput input);
    public void visit(DateInput input);
    public void visit(DecInput input);
    public void visit(IntInput input);
    public void visit(StrInput input);
    public void visit(Label label);
}
