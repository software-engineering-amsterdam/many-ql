package ql.gui.input;

import javafx.scene.layout.VBox;
import ql.gui.GuiElement;
import ql.gui.control.Control;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class Input extends GuiElement
{
    private String id;
    private Boolean disabled;
    protected VBox inputNode;
    protected final Control control;

    public Input(String id, Control control, Boolean visible, Boolean disabled)
    {
        super(visible);
        this.id = id;
        this.control = control;
        this.disabled = disabled;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public VBox getInputNode()
    {
        return this.inputNode;
    }

    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
        this.inputNode.setVisible(visible);
        this.inputNode.setManaged(visible);
    }

    public String getId()
    {
        return id;
    }

    protected abstract VBox createInputNode(Control control);
}