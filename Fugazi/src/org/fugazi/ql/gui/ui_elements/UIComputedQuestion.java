package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.IWidget;

public class UIComputedQuestion extends UIQuestion {

    public UIComputedQuestion(
            IMediator _med, 
            ComputedQuestion _question,
            IWidget _widget,
            ExpressionValue _value) 
    {
        super(_med, _question, _widget);
    }
    
    @Override
    public ExpressionValue getState() {
        return null;
    }

    @Override
    public void resetState() {
    }
    
    public void setComputedValue(ExpressionValue _value) {
        this.widget.setValue(_value.getValue().toString());
    }
}
