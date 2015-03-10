package lang.ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;

/**
 * Created by Nik on 10-3-15.
 */
public interface ControlType
{
    public void setDisabled(Boolean disabled);
    public void setVisible(Boolean visible);

    public void addListener(ChangeListener listener);

    public Node getGuiElement();
}
