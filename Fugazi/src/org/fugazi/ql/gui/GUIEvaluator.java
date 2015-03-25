package org.fugazi.ql.gui;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.evaluator.Evaluator;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIQuestion;

import java.util.List;
import java.util.Map;

public class GUIEvaluator {

    private final Evaluator evaluator;
    private final ValueStorage valueStorage;

    public GUIEvaluator(ValueStorage _valueStorage) {
        this.valueStorage = _valueStorage;
        this.evaluator = new Evaluator(valueStorage);
    }

    private ExpressionValue evaluateComputedQuestion(ComputedQuestion _computedQuest) {
        Expression expression = _computedQuest.getComputedExpression();
        return evaluator.evaluateExpression(expression);
    }

    public ExpressionValue evaluateComputedExpression(ComputedQuestion _computedQuest) {
        ExpressionValue result = this.evaluateComputedQuestion(_computedQuest);
        valueStorage.saveValue(_computedQuest.getIdName(), result);
        return result;
    }

    public boolean evaluateIfStatement(IfStatement _ifStatement) {
        Expression condition = _ifStatement.getCondition();
        return this.getConditionResult(condition);
    }
    
    private boolean getConditionResult(Expression _condition) {
        ExpressionValue expressionValue = this.evaluator.evaluateExpression(_condition);
        BoolValue result;
        if (!expressionValue.isUndefined()) {
            result = (BoolValue) expressionValue;
        } else {
            result = new BoolValue(false);
        }
        return result.getValue();
    }
}
