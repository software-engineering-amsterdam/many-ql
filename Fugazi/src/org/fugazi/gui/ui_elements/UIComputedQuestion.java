package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.widgets.Label;

public class UIComputedQuestion extends UIQuestion {

    public UIComputedQuestion(IMediator _med, ComputedQuestion _question, ExpressionValue _value) {
        super(_med, _question);

        this.widget = new Label(_question.getLabel(), _value.getValue().toString());
    }
    
    @Override
    public ExpressionValue getState() {
        return null;
    }
    
    public void setComputedValue(ExpressionValue _value) {
        this.widget.setValue(_value.getValue().toString());
    }
}
