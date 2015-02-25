package org.fugazi.gui.visitor;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.IStatementVisitor;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.evaluator.expression_value.BoolValue;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.ui_elements.UIComputedQuestion;
import org.fugazi.gui.ui_elements.UIQuestion;

public class UIStatementVisitor implements IStatementVisitor<UIQuestion> {
    
    private final Evaluator evaluator;
    private final UIMediator mediator;
    
    public UIStatementVisitor(Evaluator _evaluator, UIMediator _mediator) {
        this.evaluator = _evaluator;
        this.mediator = _mediator;
    }

    private void evaluateIfStatement(IfStatement _ifStatement) {

        System.out.println("Condition: " + _ifStatement.getCondition().toString());

        Expression condition = _ifStatement.getCondition();

        // todo: no casting?
        BoolValue result = (BoolValue) this.evaluator.evaluateExpression(condition);
        System.out.println("Condition - Result: " + result.getValue());

        if (result.getValue()) {
            _ifStatement.getBody()
                    .forEach(statement -> statement.accept(this));
        }
    }

    private void evaluateComputedQuestion(ComputedQuestion _computedQuest) {

        Expression expression = _computedQuest.getComputedExpression();
        ExpressionValue result = evaluator.evaluateExpression(expression);

        System.out.println("Computed Expression : " + expression.toString());
        System.out.println("Computed Expression - Result: " + result.getValue());
        // todo: set the result.
    }

    public UIQuestion visitQuestion(Question _question) {

        return _question.getType().accept(new UITypeVisitor(mediator, _question));
    }

    public UIQuestion visitIfStatement(IfStatement _ifStatement) {

        this.evaluateIfStatement(_ifStatement);
        return null;
    }

    public UIQuestion visitComputedQuestion(ComputedQuestion _computedQuest) {

        UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(mediator, _computedQuest);
        this.evaluateComputedQuestion(_computedQuest);

        return uiComputedQuestion;
    }
}