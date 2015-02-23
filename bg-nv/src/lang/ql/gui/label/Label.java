package lang.ql.gui.label;

import lang.ql.gui.GuiElement;
import lang.ql.gui.GuiVisitor;

/**
 * Created by Nik on 22-02-2015
 */
public class Label extends GuiElement
{
    private String label;
    public Label(String label)
    {
        this.label = label;
    }

    public void accept(GuiVisitor visitor)
    {
        visitor.visit(this);
    }
}
