package lang.ql.gui;


import java.util.Observable;

/**
 * Created by Nik on 23-2-15.
 */
public abstract class GuiElement extends Observable
{
    private Boolean visible;

    public GuiElement()
    {
        this.visible = true;
    }

    public GuiElement(Boolean visible)
    {
        this.visible = visible;
    }

    public abstract <T> T accept(GuiVisitor<T> visitor);

    public Boolean getVisible()
    {
        return visible;
    }

    public void setVisible(Boolean visible)
    {
        this.visible = visible;
        setChanged();
        notifyObservers();
    }
}
