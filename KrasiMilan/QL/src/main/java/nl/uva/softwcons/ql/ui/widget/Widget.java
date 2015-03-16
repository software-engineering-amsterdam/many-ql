package nl.uva.softwcons.ql.ui.widget;

import javafx.scene.Node;
import nl.uva.softwcons.ql.eval.ValueChangeListener;
import nl.uva.softwcons.ql.eval.value.Value;

public abstract class Widget {

    public abstract void addListener(ValueChangeListener<Value> listener);

    public abstract void setValue(Value value);

    public abstract void setEditable(boolean editable);

    public abstract Node getWidget();

}
