package com.klq.gui.pane;

import com.klq.gui.InputValidator;
import com.klq.logic.controller.Store;
import com.klq.logic.question.Question;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

/**
 * Created by Timon on 09.03.2015.
 */
public class DateQuestionPane extends AQuestionPane {
    private final int DATE_SPACING = 5;

    public DateQuestionPane(Question question, Store store) {
        super(question, store);
    }

    @Override
    protected Node createInputControl() {
        VBox container = new VBox(DATE_SPACING);
        Label dateLabel = new Label("Please select a date:");
        dateLabel.setWrapText(true);
        container.getChildren().add(dateLabel);

        final DatePicker datePicker = new DatePicker();
        if (question.isComputedQuestion()){
            LocalDate lDate = LocalDate.parse(question.computedProperty().toString());
            datePicker.setEditable(false);
            datePicker.getEditor().setEditable(false);
            datePicker.setValue(lDate);
            //TODO disable button somehow
        }
        datePicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                if (InputValidator.matches(question.getType(), newValue))
                    questionAnswered(newValue);
        });

        question.visibleProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue)
                    questionAnswered(null);
        });

        container.getChildren().add(datePicker);
        return container;
    }
}
