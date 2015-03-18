package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.semantics.values.Value;
import ql.semantics.values.ValueVisitor;

/**
 * Created by Nik on 10-3-15.
 */
// TODO: "Possibly, the Control classes contain too much public methods. Shouldn't setValue be enough?"
public interface Control extends ValueVisitor
{
    public void setDisabled(Boolean disabled);
    public void setVisible(Boolean visible);
    public void setValue(Value value);
    public Node getControlNode();

    public void addListener(ChangeListener listener);

    public <T> T accept(ControlVisitor<T> visitor);
}
