package org.fugazi.ql.gui.ui_elements.ui_questions;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;

public class UIBoolQuestion extends UIQuestion {

    private BoolValue value;

    public UIBoolQuestion(IMediator _med, Question _question, IWidget _widget) {
        super(_med, _question, _widget);

        this.resetState();

        this.widget.addEventListener(
            new WidgetsEventListener() {
                public void stateChanged() {
                    setState(widget.getWidgetValue());
                }
            }
        );
    }

    @Override
    public void setState(ExpressionValue _value) {
        this.value = (BoolValue) _value;
        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return this.value;
    }

    @Override
    public void resetState() {
        BoolValue falseValue = new BoolValue(false);
        this.value = falseValue;
        this.widget.setWidgetValue(falseValue);
    }
}
