package com.klq.gui.pane;

import com.klq.ast.impl.expr.value.Value;
import com.klq.logic.controller.Store;
import com.klq.logic.question.OptionSet;
import com.klq.logic.question.Question;
import com.klq.logic.question.Type;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * Created by Timon on 09.03.2015.
 */
public class SetQuestionPane extends AQuestionPane {
    private final static int TOGGLE_SPACING = 5;

    public SetQuestionPane(Question question, Store store) {
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

        if (question.getType() == Type.BOOLEAN){
            createRadioButton("Yes", group);
            createRadioButton("No", group);
        } else {
            OptionSet optionSet = question.getOptions();
            for (int i=0; i< optionSet.size(); i++) {
                Value answer = optionSet.get(i).evaluate(store.getVariables());
                RadioButton rb = createRadioButton(answer.toString(), group);
                container.getChildren().add(rb);
            }
        }
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
}
