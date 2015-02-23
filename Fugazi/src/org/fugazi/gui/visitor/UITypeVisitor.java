package org.fugazi.gui.visitor;

import org.fugazi.ast.statement.Question;
import org.fugazi.ast.type.*;
import org.fugazi.gui.ui_elements.UIBoolQuestion;
import org.fugazi.gui.ui_elements.UINumQuestion;
import org.fugazi.gui.ui_elements.UIQuestion;
import org.fugazi.gui.ui_elements.UITextQuestion;

public class UITypeVisitor implements ITypeVisitor <UIQuestion> {

    private final Question question;

    public UITypeVisitor(Question _question) {
        this.question = _question;
    }

    public UIQuestion visitBoolType(BoolType boolType) {
        return new UIBoolQuestion(this.question);
    }

    public UIQuestion visitIntType(IntType intType) {
        return new UINumQuestion(this.question);

    }

    public UIQuestion visitStringType(StringType moneyType) {
        return new UITextQuestion(this.question);
    }

    public UIQuestion visitUndefinedType(UndefinedType undefinedType) {
        return null;
    }
}
