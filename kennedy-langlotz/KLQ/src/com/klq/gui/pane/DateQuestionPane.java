package com.klq.gui.pane;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.DateValue;
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
            AExpression date = question.getComputedExpression();
            DateValue value = (DateValue) (date.evaluate(store.getVariables()));
            LocalDate lDate = LocalDate.parse(value.toString());
            datePicker.setValue(lDate);
            datePicker.setDisable(true);
        }
        datePicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                if (matchesInput(newValue)){
                    datePicker.setStyle("-fx-border-color: cornflowerblue");
                    questionAnswered(newValue);
                } else {
                    datePicker.setStyle("-fx-border-color: red");
                }
        });

        question.visibleProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue)
                    questionAnswered(null);
        });

        container.getChildren().add(datePicker);
        return container;
    }

    @Override
    protected boolean matchesInput(String input) {
        String pattern = "\\d?\\d[\\./-]\\d?\\d[\\./-]\\d\\d\\d\\d";
        if (input.matches(pattern))
            return true;
        return false;
    }
}
