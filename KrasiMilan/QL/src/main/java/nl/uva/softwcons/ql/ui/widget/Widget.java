package nl.uva.softwcons.ql.ui.widget;

import javafx.scene.Node;
import nl.uva.softwcons.ql.eval.ValueChangeListener;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;

public abstract class Widget {

    public abstract void addListener(ValueChangeListener<Value> listener);

    public abstract void setValue(Value value);

    public abstract void setEditable(boolean editable);

    @SuppressWarnings("rawtypes")
    public abstract void setConverter(ValueConverter converter);

    public abstract Node getWidget();

}
