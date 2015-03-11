package nl.uva.softwcons.ql.ui.widget;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
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
        yesButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            valueProperty.setValue(converter.toValue(newValue));
        });
    }

    @Override
    public Node getWidget() {
        return hbox;
    }

    @Override
    public void setValue(final Value value) {
        if (value.inConditionalContext()) {
            group.selectToggle(yesButton);
            return;
        }
        group.selectToggle(noButton);
    }

    @Override
    public void setEditable(boolean editable) {
        this.hbox.setDisable(!editable);
    }

    @Override
    public Property<Value> getValueProperty() {
        return valueProperty;
    }

}
