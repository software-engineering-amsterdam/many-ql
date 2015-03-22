package org.fugazi.qls.ast;

import org.fugazi.ql.ast.type.*;
import org.fugazi.qls.ast.widget.QLSCheckBox;
import org.fugazi.qls.ast.widget.QLSSlider;
import org.fugazi.qls.ast.widget.QLSTextBox;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;

/**
 * Type Visitor used for Default Widget creation of a given question type.
 */
public class DefaultWidgetsFactory implements ITypeVisitor <AbstractQLSWidget> {

    private String questionLabel;

    public AbstractQLSWidget getDefaultWidget(Type _type, String _questionLabel) {
        this.questionLabel = _questionLabel;
        return _type.accept(this);
    }

    public AbstractQLSWidget visitBoolType(BoolType _boolType) {
        return new QLSCheckBox(this.questionLabel);
    }

    public AbstractQLSWidget visitIntType(IntType _intType) {
        return new QLSSlider(this.questionLabel);
    }

    public AbstractQLSWidget visitStringType(StringType _stringType) {
        return new QLSTextBox(this.questionLabel);
    }

    public AbstractQLSWidget visitUndefinedType(UndefinedType _undefinedType) {
        throw new AssertionError();
    }
}