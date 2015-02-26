package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.IntValue;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.widgets.TextBox;

//TODO
public class UIComputedQuestion extends UIQuestion {

    private String textValue;

    public UIComputedQuestion(IMediator _med, ComputedQuestion _question) {
        super(_med, _question);
        this.textValue = "";

        // TODO: get it from a GUI Designer
        this.widget = new TextBox(_question.getLabel());
    }
    
    @Override
    public ExpressionValue getState() {
        return new IntValue(Integer.parseInt(textValue));
    }
}
