package com.klq.gui.pane;

import com.klq.ast.impl.expr.value.Value;
import com.klq.logic.controller.Store;
import com.klq.logic.question.Question;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * Created by Timon on 09.03.2015.
 */
public class BooleanQuestionPane extends AQuestionPane {
    private final static int TOGGLE_SPACING = 5;

    public BooleanQuestionPane(Question question, Store store) {
        super(question, store);
    }

    @Override
    protected Node createInputControl() {
        VBox container = new VBox(TOGGLE_SPACING);
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
    protected boolean matchesInput(String input) {
        return true;
    }
}
