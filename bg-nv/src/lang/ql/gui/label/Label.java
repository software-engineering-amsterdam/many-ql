package lang.ql.gui.label;

import lang.ql.gui.GuiElement;
import lang.ql.gui.GuiVisitor;

/**
 * Created by Nik on 22-02-2015
 */
public class Label extends GuiElement
{
    private String text;
    public Label(String text)
    {
        this.text = text;
    }

    public <T> T accept(GuiVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    public String getText()
    {
        return text;
    }
}
