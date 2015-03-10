package com.klq.gui.pane;

import com.klq.gui.InputValidator;
import com.klq.logic.controller.Store;
import com.klq.logic.question.Question;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 * Created by Timon on 09.03.2015.
 */
public class TextQuestionPane extends AQuestionPane {
    private final int TEXTBOX_PREFERRED_WIDTH = 250;

    public TextQuestionPane(Question question, Store store) {
        super(question, store);
    }

    @Override
    protected Node createInputControl() {
        TextField inputField = new TextField();
        inputField.setPrefWidth(TEXTBOX_PREFERRED_WIDTH);
        if (question.isComputedQuestion()) {
            inputField.setDisable(true);
            inputField.textProperty().bind(question.computedProperty());
        }
        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (InputValidator.matches(question.getType(), newValue)){
                questionAnswered(newValue);
            }
        });
        return inputField;
    }
}
