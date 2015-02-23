package lang.ql.gui.canvas;

import lang.ql.gui.GuiElement;
import lang.ql.gui.GuiVisitor;
import lang.ql.gui.line.Line;

import java.util.List;

/**
 * Created by Nik on 22-02-2015
 */
public class Canvas extends GuiElement
{
    private List<Line> lines;

    public Canvas(List<Line> lines)
    {
        this.lines = lines;
    }

    public void accept(GuiVisitor visitor)
    {
        visitor.visit(this);
    }


}
