package org.fugazi.ql.gui.ui_element.ui_questions;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.StringValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;

public class UITextQuestion extends UIQuestion {

    private StringValue value;
    
    public UITextQuestion(IMediator _med, Question _question, IWidget _widget) {
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
        this.value = (StringValue) _value;
        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return this.value;
    }

    @Override
    public void resetState() {
        StringValue emptyValue = new StringValue("");
        this.value = emptyValue;
        this.widget.setWidgetValue(emptyValue);
    }
}
