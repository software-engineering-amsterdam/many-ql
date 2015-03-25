package org.fugazi.ql.gui.ui_elements.ui_questions;

import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.UndefinedValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.IWidget;

public class UIComputedQuestion extends UIQuestion {

    private ExpressionValue value;
    
    public UIComputedQuestion(
            IMediator _med, 
            ComputedQuestion _question,
            IWidget _widget,
            ExpressionValue _value) 
    {
        super(_med, _question, _widget);
        this.value = _value;
    }

    @Override
    public void setState(ExpressionValue _value) {
        this.value = _value;
    }

    @Override
    public ExpressionValue getState() {
        return this.value;
    }

    @Override
    public void resetState() {
        this.value = new UndefinedValue();
    }
    
    public void setComputedValue(ExpressionValue _value) {
        this.widget.setWidgetValue(_value);
    }
}
