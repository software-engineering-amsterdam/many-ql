package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.BoolValue;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.widgets.CheckBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UIBoolQuestion extends UIQuestion {

    private boolean isSelected;

    public UIBoolQuestion(UIMediator _med, Question _question) {
        super(_med, _question);
        this.isSelected = false;

        // TODO: get it from a GUI Designer
        this.widget = new CheckBox(_question.getLabel());

        // todo: change that.
        this.widget.addEventListener((ItemListener)event -> itemChanged(event));
    }

    private void itemChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            this.setState(new BoolValue(true));
        } else {
            this.setState(new BoolValue(false));
        }
    }

    @Override
    public void setState(ExpressionValue _value) {
        BoolValue exprValue = (BoolValue) _value;
        this.isSelected = exprValue.getValue();

        this.send();
    }

    @Override
    public ExpressionValue getState() {
        return new BoolValue(isSelected);
    }
}
