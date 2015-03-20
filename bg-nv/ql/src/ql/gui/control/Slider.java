package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import ql.semantics.values.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Nik on 16-3-15.
 */
public class Slider extends ControlElement implements IntControl, DecControl
{
    private final javafx.scene.control.Slider slider;
    private final Text sliderTextValue;
    private final VBox controlNode;
    private Double defaultValue;
    private NumberFormat formatter;

    public Slider(Boolean visible, Boolean disabled, Integer startValue, Integer endValue, Integer step)
    {
        this(visible, disabled, startValue.doubleValue(), endValue.doubleValue(), step.doubleValue(), "#0");
     }

    public Slider(Boolean visible, Boolean disabled, Double startValue, Double endValue, Double step)
    {
        this(visible, disabled, startValue.doubleValue(), endValue.doubleValue(), step.doubleValue(), "#0.00");
    }

    private Slider(Boolean visible, Boolean disabled, Double startValue, Double endValue, Double step, String format)
    {
        super(visible, disabled);
        this.slider = new javafx.scene.control.Slider(startValue, endValue, step);
        this.formatter = new DecimalFormat(format);

        this.defaultValue = startValue;

        this.sliderTextValue = new Text();

        this.sliderTextValue.setTextAlignment(TextAlignment.RIGHT);

        this.controlNode = new VBox();
        this.controlNode.getChildren().addAll(this.slider, this.sliderTextValue);

        this.slider.valueProperty().addListener(this.createSliderTextUpdateListener());
        this.slider.setValue(this.defaultValue);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.slider.setDisable(disabled);
    }

    @Override
    public void setValue(Value value)
    {
        value.accept(this);
    }

    @Override
    public Void visit(DecValue val)
    {
        this.slider.setValue(val.getValue().doubleValue());
        return null;
    }

    @Override
    public Void visit(IntValue val)
    {
        this.slider.setValue(val.getValue().doubleValue());
        return null;
    }

    @Override
    public Void visit(UndefValue val)
    {
        this.slider.setValue(this.defaultValue);
        return null;
    }

    @Override
    public Node getControlNode()
    {
        return this.controlNode;
    }

    @Override
    public void addListener(ChangeListener listener)
    {
        this.slider.valueProperty().addListener(listener);
    }

    @Override
    public Value getIntValue()
    {
        Double d = this.slider.getValue();
        Long rounded = Math.round(d);
        return new IntValue(rounded.intValue());
    }

    @Override
    public Value getDecValue()
    {
        Double v = this.slider.getValue();
        BigDecimal bd = new BigDecimal(v.doubleValue());
        return new DecValue(bd);
    }

    private ChangeListener<Number> createSliderTextUpdateListener()
    {
        return (observable, oldValue, newValue) -> sliderTextValue.setText(formatter.format(newValue).toString());
    }

    @Override
    public <T> T accept(ControlVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
