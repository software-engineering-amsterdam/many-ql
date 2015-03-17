package com.klq.gui.control;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.controller.Controller;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Created by Timon on 09.03.2015.
 */
public class DateRenderedQuestion extends ARenderedQuestion {
    private TextField inputField;

    public DateRenderedQuestion(QuestionNode question, List<AExpression> dependencies, Controller controller) {
        super(question, dependencies, controller);
    }

    @Override
    protected Region createQuestionControl() {
        VBox container = new VBox(5);
        Label dateLabel = new Label("Please select a date:");
        dateLabel.setWrapText(true);
        container.getChildren().add(dateLabel);

        final DatePicker datePicker = new DatePicker();
        inputField = datePicker.getEditor();
        datePicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                if (isValidInput(newValue)){
                    datePicker.setStyle("-fx-border-color: cornflowerblue");
                    questionAnswered(newValue);
                } else {
                    datePicker.setStyle("-fx-border-color: red");
                }
        });

        visibleProperty.addListener((observable, oldValue, newValue) -> {
            if (!newValue)
                questionAnswered(null);
        });

        container.getChildren().add(datePicker);
        return container;
    }

    @Override
    protected boolean isValidInput(String input) {
        String pattern = "\\d?\\d[\\./-]\\d?\\d[\\./-]\\d\\d\\d\\d";
        if (input.matches(pattern))
            return true;
        return false;
    }
}
