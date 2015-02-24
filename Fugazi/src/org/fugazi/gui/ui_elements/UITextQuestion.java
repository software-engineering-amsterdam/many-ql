package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.StringValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.widgets.TextBox;

import java.awt.event.ActionEvent;

public class UITextQuestion extends UIQuestion {

    private String textValue;

    public UITextQuestion(UIMediator _med, Question _question) {
        super(_med, _question);
        this.textValue = "";

        // TODO: get it from a GUI Designer
        this.widget = new TextBox(_question.getLabel());
        //JTextField textField = ((TextBox)this.widget).getTextField();
        //textField.addActionListener(event -> itemChanged(event)); // lambda
    }

    @Override
    public void setState(ExpressionValue _value) {
        StringValue exprValue = (StringValue) _value;
        this.textValue = exprValue.getValue();

        this.sendToMediator();
    }

    private void itemChanged(ActionEvent e) {

        //JTextField textField = ((TextBox)this.widget).getTextField();
        //this.setState(new StringValue(textField.getText()));
    }

    @Override
    public ExpressionValue getState() {
        return new StringValue(textValue);
    }
}
