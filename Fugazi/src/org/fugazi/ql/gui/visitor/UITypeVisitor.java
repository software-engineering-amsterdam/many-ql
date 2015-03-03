package org.fugazi.ql.gui.visitor;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.UIBoolQuestion;
import org.fugazi.ql.gui.ui_elements.UINumQuestion;
import org.fugazi.ql.gui.ui_elements.UIQuestion;
import org.fugazi.ql.gui.ui_elements.UITextQuestion;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.ITypeVisitor;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;

public class UITypeVisitor implements ITypeVisitor<UIQuestion> {

    private final Question question;
    private final IMediator mediator;

    public UITypeVisitor(IMediator _med, Question _question) {
        this.question = _question;
        this.mediator = _med;
    }

    public UIQuestion visitBoolType(BoolType boolType) {
        return new UIBoolQuestion(this.mediator, this.question);
    }

    public UIQuestion visitIntType(IntType intType) {
        return new UINumQuestion(this.mediator, this.question);

    }

    public UIQuestion visitStringType(StringType moneyType) {
        return new UITextQuestion(this.mediator, this.question);
    }
}
