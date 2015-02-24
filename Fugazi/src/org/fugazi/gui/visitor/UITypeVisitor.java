package org.fugazi.gui.visitor;

import org.fugazi.ast.statement.Question;
import org.fugazi.ast.type.*;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.ui_elements.UIBoolQuestion;
import org.fugazi.gui.ui_elements.UINumQuestion;
import org.fugazi.gui.ui_elements.UIQuestion;
import org.fugazi.gui.ui_elements.UITextQuestion;

public class UITypeVisitor implements ITypeVisitor <UIQuestion> {

    private final Question question;
    private final UIMediator mediator;

    public UITypeVisitor(UIMediator _med, Question _question) {
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
