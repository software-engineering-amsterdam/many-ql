package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.IntValue;
import org.fugazi.evaluator.expression_value.StringValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.widgets.TextBox;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UINumQuestion extends UIQuestion {

    private String textValue;

    public UINumQuestion(UIMediator _med, Question _question) {
        super(_med, _question);
        this.textValue = "";

        // TODO: get it from a GUI Designer
        this.widget = new TextBox(_question.getLabel());
    }

    @Override
    public void setState(ExpressionValue _value) {
        StringValue exprValue = (StringValue) _value;
        this.textValue = exprValue.getValue();

        this.mediator.send("NUmber", this);
    }

    private void itemChanged(ActionEvent e) {
    }

    @Override
    public ExpressionValue getState() {
        return new IntValue(Integer.parseInt(textValue));
    }
}
