package lang.ql.gui.control;

import javafx.scene.control.RadioButton;
import lang.ql.gui.ModelVisitor;

/**
 * Created by Nik on 10-3-15.
 */
public class Radio extends Control
{
    private final RadioButton radio;
    private Boolean value;

    public Radio(Boolean visible, Boolean disabled, Boolean value, String label)
    {
        super(visible, disabled);
        this.radio = new RadioButton(label);
        this.value = value;
    }

    public void setDisabled(Boolean disabled)
    {
        this.radio.setDisable(disabled);
    }

    public void setSelected(Boolean selected)
    {
        this.radio.setSelected(selected);
    }

    @Override
    public void setVisible(Boolean visible)
    {
        this.radio.setVisible(visible);
        this.radio.setManaged(visible);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return null;
    }
}
