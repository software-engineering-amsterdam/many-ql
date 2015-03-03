package lang.ql.gui.canvas;

import lang.ql.gui.GuiElement;
import lang.ql.gui.ModelVisitor;
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
        super();
        this.name = name;
        this.lines = lines;
    }

    public Canvas(String name, List<Line> lines, Boolean visible)
    {
        super(visible);
        this.name = name;
        this.lines = lines;
    }

    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
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
