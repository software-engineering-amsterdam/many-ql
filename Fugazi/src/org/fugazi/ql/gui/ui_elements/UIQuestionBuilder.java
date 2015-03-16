package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IStatementVisitor;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.GUIEvaluator;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.ql.gui.widgets.TypeToWidgetVisitor;

public class UIQuestionBuilder implements IStatementVisitor<UIQuestion> {

    private final IMediator mediator;
    private final GUIEvaluator guiEvaluator;

    public UIQuestionBuilder(IMediator _med, ValueStorage _valueStorage) {
        this.mediator = _med;
        this.guiEvaluator = new GUIEvaluator(_valueStorage);
    }

    public UIQuestion visitQuestion(Question _question) {
        TypeToWidgetVisitor typeToWidgetVisitor = new TypeToWidgetVisitor(_question.getLabel());
        IWidget widget = _question.getType().accept(typeToWidgetVisitor);

        TypeToUIQuestionVisitor typeToUIQuestionVisitor =
                new TypeToUIQuestionVisitor(this.mediator, _question, widget);

        return  _question.getType().accept(typeToUIQuestionVisitor);
    }

    public UIQuestion visitIfStatement(IfStatement _ifStatement) {
        throw new AssertionError();
    }

    public UIQuestion visitComputedQuestion(ComputedQuestion _computedQuestion) {
        ExpressionValue result = guiEvaluator.evaluateComputedExpression(_computedQuestion);
        TypeToWidgetVisitor typeToWidgetVisitor = new TypeToWidgetVisitor(_computedQuestion.getLabel());
        IWidget widget = _computedQuestion.getType().accept(typeToWidgetVisitor);

        widget.setValue(result);
        widget.setReadOnly(true);

        return new UIComputedQuestion(mediator, _computedQuestion, widget, result);
    }
}