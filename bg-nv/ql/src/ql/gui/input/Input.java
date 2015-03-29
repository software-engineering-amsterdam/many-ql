package ql.gui.input;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import ql.gui.GuiElement;
import ql.gui.control.Control;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class Input<T extends Control> extends GuiElement
{
    private String id;
    private Boolean disabled;
    protected final VBox inputNode;
    protected T control;

    public Input(String id, T control, Boolean disabled)
    {
        this.id = id;
        this.control = control;
        this.disabled = disabled;
        this.inputNode = new VBox();
        this.control.setDisabled(disabled);
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

    protected void fillInputNode()
    {
        this.inputNode.getChildren().add(this.control.getControlNode());
        this.inputNode.setAlignment(Pos.TOP_RIGHT);
        this.setVisible(this.getVisible());
    }

    public void switchControl(T control)
    {
        control.setDisabled(this.disabled);
        this.inputNode.getChildren().clear();
        this.control = control;
        this.fillInputNode();
    }

    public abstract <V> V accept(InputVisitor<V> visitor);
}