package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.Label;

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
