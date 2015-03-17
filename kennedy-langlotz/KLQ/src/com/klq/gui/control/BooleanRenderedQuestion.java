package com.klq.gui.control;

import com.klq.ast.impl.Type;
import com.klq.ast.impl.expr.AExpression;
import com.klq.controller.Store;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Created by Timon on 09.03.2015.
 */
public class BooleanRenderedQuestion extends ARenderedQuestion {

    public BooleanRenderedQuestion(String id, Type type, String text, List<AExpression> dependencies, Store store) {
        super(id, type, text, dependencies, store);
    }

    @Override
    protected Region createQuestionControl() {
        VBox container = new VBox(5);
        ToggleGroup group = createToggleGroup(container);

        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            String value = observable.getValue().toString();
            value = value.substring(value.indexOf("'")+1, value.lastIndexOf("'"));
            questionAnswered(value);
        });
        return container;
    }

    private ToggleGroup createToggleGroup(VBox container){
        ToggleGroup group = new ToggleGroup();
        RadioButton yesButton = createRadioButton("Yes", group);
        RadioButton noButton = createRadioButton("No", group);
        container.getChildren().add(yesButton);
        container.getChildren().add(noButton);

        return group;
    }

    private RadioButton createRadioButton(String text, ToggleGroup group){
        RadioButton rb = new RadioButton(text);
        rb.setWrapText(true);
        rb.setFont(DEFAULT_FONT);
        rb.setToggleGroup(group);
        rb.setSelected(false);
        return rb;
    }

    @Override
    protected boolean isValidInput(String input) {
        return true;
    }
}
