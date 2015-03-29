package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.semantics.values.Value;
import ql.semantics.values.ValueVisitor;

/**
 * Created by Nik on 10-3-15.
 */
public interface Control extends ValueVisitor
{
    public void setDisabled(Boolean disabled);
    public void setValue(Value value);
    public Node getControlNode();

    public void addListener(ChangeListener listener);

    public <T> T accept(ControlVisitor<T> visitor);
}
