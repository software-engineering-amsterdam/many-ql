package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.ast.type.*;

public class TypeToWidgetVisitor implements ITypeVisitor<IWidget> {

    private final String questionLabel;

    public TypeToWidgetVisitor(String _questionLabel) {
        this.questionLabel = _questionLabel;
    }

    public IWidget visitBoolType(BoolType _boolType) {
        return new CheckBox(this.questionLabel);
    }

    public IWidget visitIntType(IntType _intType) {
        return new IntegerOnlyTextBox(this.questionLabel);
    }

    public IWidget visitStringType(StringType _stringType) {
        return new TextBox(this.questionLabel);
    }

    public IWidget visitUndefinedType(UndefinedType _undefinedType) {
        throw new RuntimeException();
    }
}
