package ql.gui.input;

import javafx.scene.layout.VBox;
import ql.gui.GuiElement;
import ql.gui.control.BoolControl;
import ql.gui.control.Control;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class Input<T extends Control> extends GuiElement
{
    private String id;
    private Boolean disabled;
    protected VBox inputNode;
    protected T control;

    public Input(String id, T control, Boolean visible, Boolean disabled)
    {
        super(visible);
        this.id = id;
        this.control = control;
        this.disabled = disabled;
//        this.control.setDisabled(disabled);
//        this.control.setVisible(visible);
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

//    public void setDisabled(Boolean disabled)
//    {
//        this.disabled = disabled;
//    }

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

    public void switchControl(T control)
    {
        //TODO: take care that the input node is reconstructed correctly
        control.setDisabled(this.getDisabled());
        control.setVisible(this.getVisible());
        this.inputNode.getChildren().remove(this.control.getControlNode());
        this.control = control;
        this.inputNode.getChildren().add(this.control.getControlNode());
    }
}