package nl.uva.softwcons.ql.ui.widget;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.conveter.ValueConverter;

public class RadioButtonWidget extends Widget {

    private RadioButton yesButton;
    private RadioButton noButton;

    private HBox hbox;
    private ToggleGroup group;
    private Property<Value> valueProperty;

    public RadioButtonWidget(String yesString, String noString, final ValueConverter<Boolean> converter) {
        this.valueProperty = new SimpleObjectProperty<Value>();

        yesButton = new RadioButton(yesString);
        noButton = new RadioButton(noString);

        // TODO move this to UiBuilder
        noButton.setSelected(true);

        hbox = new HBox();
        hbox.getChildren().add(yesButton);
        hbox.getChildren().add(noButton);

        group = new ToggleGroup();

        yesButton.setToggleGroup(group);
        noButton.setToggleGroup(group);

        // TODO discuss how to fix code duplication
        yesButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                valueProperty.setValue(converter.toValue(newValue));
            }
        });
    }

    @Override
    public Node getWidget() {
        return hbox;
    }

    @Override
    public void setValue(Value value) {
        if (value.asBoolean()) {
            group.selectToggle(yesButton);
            return;
        }
        group.selectToggle(noButton);
    }

    @Override
    public void setVisible(boolean visible) {
        this.hbox.setVisible(visible);
    }

    @Override
    public Property<Value> getValueProperty() {
        return valueProperty;
    }

}
