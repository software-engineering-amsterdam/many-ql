package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.IntValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.widgets.TextBox;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UIComputedQuestion extends UIQuestion {

    private String textValue;

    public UIComputedQuestion(UIMediator _med, Question _question) {
        super(_med, _question);
        this.textValue = "";

        // TODO: get it from a GUI Designer
        this.widget = new TextBox(_question.getLabel());
        //JTextField textField = ((TextBox)this.widget).getTextField();
       // textField.addActionListener(event -> itemChanged(event)); // lambda
    }

    @Override
    public void setState(ExpressionValue _value) {
        IntValue exprValue = (IntValue) _value;
        this.textValue = Integer.toString(exprValue.getValue());

        this.send();
    }

    private void itemChanged(ActionEvent e) {

        //JTextField textField = ((TextBox)this.widget).getTextField();
        //this.setState(new IntValue(Integer.parseInt(textField.getText())));
    }

    @Override
    public ExpressionValue getState() {
        return new IntValue(Integer.parseInt(textValue));
    }
}
