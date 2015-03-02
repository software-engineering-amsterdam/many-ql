package nl.uva.softwcons.ui.widget;

import javafx.scene.Node;
import nl.uva.softwcons.eval.value.Value;

public abstract class Widget {

    public abstract void setValue(Value value);

    public abstract Node getWidget();

    public abstract void processValueChanged(Value oldValue, Value newValue);

}
