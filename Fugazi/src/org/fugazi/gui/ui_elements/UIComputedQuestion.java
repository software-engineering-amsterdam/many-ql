package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.widgets.Label;

//TODO
public class UIComputedQuestion extends UIQuestion {

    public UIComputedQuestion(IMediator _med, ComputedQuestion _question, String _value) {
        super(_med, _question);

        // TODO: get it from a GUI Designer
        this.widget = new Label(_question.getLabel(), _value);
    }
    
    @Override
    public ExpressionValue getState() {
        return null;
    }
}
