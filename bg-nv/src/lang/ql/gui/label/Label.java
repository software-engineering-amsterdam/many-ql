package lang.ql.gui.label;

import lang.ql.gui.GuiElement;
import lang.ql.gui.GuiModelVisitor;

/**
 * Created by Nik on 22-02-2015
 */
public class Label extends GuiElement
{
    private String text;

    public Label(String text)
    {
        super();
        this.text = text;
    }

    public Label(String text, Boolean visible)
    {
        super(visible);
        this.text = text;
    }

    public <T> T accept(GuiModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    public String getText()
    {
        return text;
    }
}
