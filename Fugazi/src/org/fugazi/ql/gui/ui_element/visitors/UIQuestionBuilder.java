package org.fugazi.ql.gui.ui_element.visitors;

import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IStatementVisitor;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.GUIEvaluator;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_element.ui_questions.UIComputedQuestion;
import org.fugazi.ql.gui.ui_element.ui_questions.UIQuestion;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.ql.gui.widgets.WidgetsFactory;

public class UIQuestionBuilder implements IStatementVisitor <UIQuestion>{

    private final IMediator mediator;
    private final GUIEvaluator guiEvaluator;
    private final WidgetsFactory widgetsFactory;

    public UIQuestionBuilder(
            IMediator _med, ValueStorage _valueStorage, WidgetsFactory _widgetsFactory)
    {
        this.mediator = _med;
        this.guiEvaluator = new GUIEvaluator(_valueStorage);
        this.widgetsFactory = _widgetsFactory;
    }

    public UIQuestion visitQuestion(Question _question) {
        IWidget widget = this.widgetsFactory.getWidgetForQuestion(_question);
        TypeToUIQuestionVisitor typeToUIQuestionVisitor =
                new TypeToUIQuestionVisitor(this.mediator, _question, widget);
        return  _question.getType().accept(typeToUIQuestionVisitor);
    }

    public UIQuestion visitIfStatement(IfStatement _ifStatement) {
        throw new AssertionError(); // Should never go in here, this is used as a factory.
    }

    public UIQuestion visitComputedQuestion(ComputedQuestion _computedQuestion) {
        ExpressionValue result = guiEvaluator.evaluateComputedExpression(_computedQuestion);
        IWidget widget = this.widgetsFactory.getWidgetForQuestion(_computedQuestion, result);
        return new UIComputedQuestion(mediator, _computedQuestion, widget, result);
    }
}