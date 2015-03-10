package lang.ql.gui.input;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;
import lang.ql.gui.GuiElement;
import lang.ql.semantics.ValueTable;

/**
 * Created by Nik on 17-2-15.
 */
//TODO: Figure out if this should/can be refactored - push Control lower, get rid of the generic?
public abstract class Input<T extends Control> extends GuiElement
{
    private String id;
    private Boolean disabled;
    protected final T control;
    private VBox inputNode;

    public Input(String id, T control, Boolean visible, Boolean disabled)
    {
        super(visible);
        this.id = id;
        this.control = control;
        this.inputNode = this.createInputNode(control);
        this.setDisabled(disabled);
        this.setVisible(visible);
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
        this.control.setDisable(disabled);
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
        this.control.setVisible(visible);
        this.control.setManaged(visible);
    }

    public String getId()
    {
        return id;
    }

    public abstract void update(ValueTable valueTable);

    protected VBox createInputNode(Control control)
    {
        VBox box = new VBox();
        box.getChildren().add(control);
        box.setAlignment(Pos.TOP_RIGHT);
        box.setVisible(this.getVisible());
        return box;
    }
}