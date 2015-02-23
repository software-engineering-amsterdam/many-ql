package lang.ql.gui;

import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;

/**
 * Created by Nik on 23-2-15.
 */
public class SimpleGui implements GuiVisitor
{
    @Override
    public void visit(Canvas c)
    {

    }

    @Override
    public void visit(Line line)
    {

    }

    @Override
    public void visit(Input input)
    {
        input.accept(this);
    }

    @Override
    public void visit(BoolInput input)
    {

    }

    @Override
    public void visit(DateInput input)
    {

    }

    @Override
    public void visit(DecInput input)
    {

    }

    @Override
    public void visit(IntInput input)
    {

    }

    @Override
    public void visit(StrInput input)
    {

    }

    @Override
    public void visit(Label label)
    {

    }
}
