package nl.uva.softwcons.qls.ui.widget;

import static nl.uva.softwcons.ql.eval.value.UndefinedValue.UNDEFINED;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import nl.uva.softwcons.ql.eval.ValueChangeListener;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class SliderWidget extends Widget {

    private final ValueConverter<Number> converter;
    private final Slider slider;

    public SliderWidget(final double start, final double end, final double step, final ValueConverter<Number> converter) {
        this.converter = converter;
        this.slider = new Slider(start, end, start);
        slider.setBlockIncrement(step);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMinorTickCount(1);
        slider.setMajorTickUnit(1f);
    }

    @Override
    public void addListener(final ValueChangeListener<Value> listener) {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            listener.processValueChange(converter.toValue(newValue));
        });
    }

    @Override
    public void setValue(final Value value) {
        if (value != UNDEFINED) {
            slider.setValue(value.getNumber().doubleValue());
        }
    }

    @Override
    public void setEditable(final boolean editable) {
        this.slider.setDisable(!editable);
    }

    @Override
    public Node getWidget() {
        return slider;
    }

}
