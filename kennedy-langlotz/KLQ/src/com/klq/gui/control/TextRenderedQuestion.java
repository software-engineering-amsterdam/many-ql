package com.klq.gui.control;

import com.klq.ast.impl.Type;
import com.klq.ast.impl.expr.AExpression;
import com.klq.controller.Store;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.util.List;

/**
 * Created by Timon on 09.03.2015.
 */
public class TextRenderedQuestion extends ARenderedQuestion {

    public TextRenderedQuestion(String id, Type type, String text, List<AExpression> dependencies, Store store) {
        super(id, type, text, dependencies, store);
    }

    @Override
    protected Region createQuestionControl() {
        TextField inputField = new TextField();
        inputField.setPrefWidth(250);
        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isValidInput(newValue)){
                inputField.setStyle("-fx-border-color: cornflowerblue");
                questionAnswered(newValue);
            } else {
                inputField.setStyle("-fx-border-color: red");
            }
        });
        return inputField;
    }

    @Override
    protected boolean isValidInput(String input) {
        if (getType() == Type.NUMERAL) {
            return input.matches("-?\\d+(\\.\\d+)?");
        }
        return true;
    }
}
