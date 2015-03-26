package org.fugazi.ql.gui.ui_elements.ui_questions;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;

public class UINumQuestion extends UIQuestion {

    private IntValue value;

    public UINumQuestion(IMediator _med, Question _question, IWidget _widget) {
        super(_med, _question, _widget);

        this.widget.addEventListener(
            new WidgetsEventListener() {
                public void stateChanged() {
                    setState(widget.getWidgetValue());
                }
            }
        );

        this.resetState();
    }

    @Override
    public void setState(ExpressionValue _value) {
        this.value = (IntValue) _value;
        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return this.value;
    }

    @Override
    public void resetState() {
        IntValue zeroValue = new IntValue(0);
        this.setState(zeroValue);
        this.widget.setWidgetValue(zeroValue);
    }
}
