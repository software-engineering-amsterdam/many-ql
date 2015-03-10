package lang.ql.gui.canvas;

import lang.ql.gui.GuiElement;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.section.Section;

import java.util.List;

/**
 * Created by Nik on 22-02-2015
 */
public class Canvas extends GuiElement
{
    private String name;
    private List<Section> sections;

    public Canvas(String name, List<Section> sections)
    {
        super();
        this.name = name;
        this.sections = sections;
    }

    public Canvas(String name, List<Section> sections, Boolean visible)
    {
        super(visible);
        this.name = name;
        this.sections = sections;
    }

    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }


    public String getName()
    {
        return name;
    }

    public List<Section> getSections()
    {
        return sections;
    }
}
