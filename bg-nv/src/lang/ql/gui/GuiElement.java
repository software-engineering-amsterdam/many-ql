package lang.ql.gui;

/**
 * Created by Nik on 23-2-15.
 */
public abstract class GuiElement
{
    public abstract <T> T accept(GuiVisitor<T> visitor);
}
