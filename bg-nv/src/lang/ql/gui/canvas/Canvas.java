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
    private String name;
    private List<Line> lines;

    public Canvas(String name, List<Line> lines)
    {
        this.name = name;
        this.lines = lines;
    }

    public void accept(GuiVisitor visitor)
    {
        visitor.visit(this);
    }


    public String getName()
    {
        return name;
    }

    public List<Line> getLines()
    {
        return lines;
    }
}
