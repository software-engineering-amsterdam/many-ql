package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.*;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIBoolQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UINumQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UITextQuestion;
import org.fugazi.ql.gui.widgets.IWidget;

public class TypeToUIQuestionVisitor implements ITypeVisitor<UIQuestion> {

    private final IMediator mediator;
    private final Question question;
    private final IWidget widget;

    public TypeToUIQuestionVisitor(IMediator _mediator, Question _question, IWidget _widget) {
        this.mediator = _mediator;
        this.question = _question;
        this.widget = _widget;
    }

    public UIQuestion visitBoolType(BoolType _boolType) {
        return new UIBoolQuestion(this.mediator, this.question, this.widget);
    }

    public UIQuestion visitIntType(IntType _intType) {
        return new UINumQuestion(this.mediator, this.question, this.widget);
    }

    public UIQuestion visitStringType(StringType _stringType) {
        return new UITextQuestion(this.mediator, this.question, this.widget);
    }

    public UIQuestion visitUndefinedType(UndefinedType _undefinedType) {
        throw new RuntimeException();
    }
}
