package nl.uva.softwcons.ql.ui.widget;

import javafx.beans.property.Property;
import javafx.scene.Node;
import nl.uva.softwcons.ql.eval.value.Value;

public abstract class Widget {

    public abstract Property<Value> getValueProperty();

    public abstract void setValue(Value value);

    public abstract void setEditable(boolean visible);

    public abstract Node getWidget();

}
