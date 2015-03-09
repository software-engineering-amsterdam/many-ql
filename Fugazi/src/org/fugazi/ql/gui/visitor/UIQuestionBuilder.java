package org.fugazi.ql.gui.visitor;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IStatementVisitor;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.Evaluator;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.*;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.ITypeVisitor;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;

public class UIQuestionBuilder implements IStatementVisitor <UIQuestion>, ITypeVisitor<UIQuestion> {

    private final Question question;
    private final IMediator mediator;
    private final ValueStorage valueStorage;
    private final Evaluator evaluator;

    public UIQuestionBuilder(
            IMediator _med, Question _question, ValueStorage _valueStorage, Evaluator _evaluator)
    {
        this.question = _question;
        this.mediator = _med;
        this.valueStorage = _valueStorage;
        this.evaluator = _evaluator;
    }

    /**
     * Type Visitor
     */
    public UIQuestion visitBoolType(BoolType boolType) {
        return new UIBoolQuestion(this.mediator, this.question);
    }

    public UIQuestion visitIntType(IntType intType) {
        return new UINumQuestion(this.mediator, this.question);

    }

    public UIQuestion visitStringType(StringType moneyType) {
        return new UITextQuestion(this.mediator, this.question);
    }

    /**
     * Statement Visitor
     */
    public UIQuestion visitQuestion(Question question) {
        return question.getType().accept(this);
    }

    public UIQuestion visitIfStatement(IfStatement ifStatement) {
        return null;
    }

    public UIQuestion visitComputedQuestion(ComputedQuestion computedQuestion) {
        ExpressionValue result = evaluateComputedExpression(computedQuestion);
        UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(mediator, computedQuestion, result);
        return uiComputedQuestion;
    }

    private ExpressionValue evaluateComputedQuestion(ComputedQuestion _computedQuest) {
        Expression expression = _computedQuest.getComputedExpression();
        return evaluator.evaluateExpression(expression);
    }

    private ExpressionValue evaluateComputedExpression(ComputedQuestion _computedQuest) {
        ExpressionValue result = this.evaluateComputedQuestion(_computedQuest);
        valueStorage.saveValue(_computedQuest.getIdName(), result);
        return result;
    }
}
