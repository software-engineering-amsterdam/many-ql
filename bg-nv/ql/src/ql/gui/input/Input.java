package ql.gui.input;

import javafx.scene.layout.VBox;
import ql.gui.GuiElement;
import ql.gui.control.Control;
import ql.semantics.ValueTable;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class Input extends GuiElement
{
    private String id;
    private Boolean disabled;
    protected VBox inputNode;

    public Input(String id, Boolean visible, Boolean disabled)
    {
        super(visible);
        this.id = id;
        this.disabled = disabled;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
//        this.control.setDisabled(disabled);
    }

    public VBox getInputNode()
    {
        return this.inputNode;
    }

    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
//        this.inputNode.setVisible(visible);
//        this.inputNode.setManaged(visible);
//        this.control.setVisible(visible);
    }

    public String getId()
    {
        return id;
    }

    public abstract void update(ValueTable valueTable);

    protected abstract VBox createInputNode(Control control);
//    {
//        VBox box = new VBox();
//        box.getChildren().add(control.getControl());
//        box.setAlignment(Pos.TOP_RIGHT);
//        box.setVisible(this.getVisible());
//        return box;
//    }
}