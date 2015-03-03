package lang.ql.gui.input;

import javafx.scene.control.Control;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.GuiElement;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.errors.Message;

/**
 * Created by Nik on 17-2-15.
 */
public abstract class Input<T extends Control> extends GuiElement
{
    private String id;
    private Boolean disabled;
    final private T control;
    private Message validationError;

    public Input(String id, T control)
    {
        this(id, control, true, false);
    }

    public Input(String id, T control, Boolean visible, Boolean disabled)
    {
        super(visible);
        this.id = id;
        this.disabled = disabled;
        this.control = control;
        this.control.setVisible(this.getVisible());
        this.control.setDisable(this.getDisabled());
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public String getId()
    {
        return id;
    }

    public T getControl()
    {
        return this.control;
    }

    public abstract void update(ValueTable valueTable);
}