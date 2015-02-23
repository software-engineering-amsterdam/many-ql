package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.IntValue;
import org.fugazi.gui.widgets.TextBox;

public class UINumQuestion extends UIQuestion {

    private String textValue;

    public UINumQuestion(Question _question) {
        super(_question);
        this.textValue = "";

        // TODO: get it from a GUI Designer
        this.widget = new TextBox(_question.getLabel());
    }

    @Override
    public void setState(ExpressionValue _value) {
        IntValue exprValue = (IntValue) _value;
        this.textValue = Integer.toString(exprValue.getValue());

        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public ExpressionValue getState() {
        return new IntValue(Integer.parseInt(textValue));
    }
}
