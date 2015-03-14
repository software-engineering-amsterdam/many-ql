package org.fugazi.ql.gui.visitor;

import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IStatementVisitor;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.GUIEvaluator;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.*;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.ITypeVisitor;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.ql.gui.widgets.WidgetsFactory;

public class UIQuestionBuilder implements IStatementVisitor <UIQuestion>, ITypeVisitor<UIQuestion> {

    private Question question;
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

    /**
     * Type Visitor
     */
    public UIQuestion visitBoolType(BoolType boolType) {
        IWidget widget = this.widgetsFactory.getDefaultWidgetForQuestion(this.question);
        
        return new UIBoolQuestion(
                this.mediator, this.question, widget);
    }

    public UIQuestion visitIntType(IntType intType) {
        IWidget widget = this.widgetsFactory.getDefaultWidgetForQuestion(this.question);
        return new UINumQuestion(
                this.mediator, this.question, widget);

    }

    public UIQuestion visitStringType(StringType stringType) {
        IWidget widget = this.widgetsFactory.getDefaultWidgetForQuestion(this.question);
        return new UITextQuestion(
                this.mediator, this.question, widget);
    }

    /**
     * Statement Visitor
     */
    public UIQuestion visitQuestion(Question question) {
        this.question = question;
        return question.getType().accept(this);
    }

    public UIQuestion visitIfStatement(IfStatement ifStatement) {
        return null;
    }

    public UIQuestion visitComputedQuestion(ComputedQuestion computedQuestion) {
        this.question = computedQuestion;
        
        ExpressionValue result = guiEvaluator.evaluateComputedExpression(computedQuestion);
        IWidget widget = 
                this.widgetsFactory.getDefaultWidgetForQuestion(this.question, result);
        
        return new UIComputedQuestion(
                mediator, computedQuestion, widget, result);
    }
}
