package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.*;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;


public class WidgetsFactory implements ITypeVisitor<IWidget> {

    private String questionLabel;

    public IWidget getWidgetForQuestion(Question _question) {
        Type type = _question.getType();
        this.questionLabel = _question.getLabel();
        return type.accept(this);
    }
    
    public IWidget getWidgetForQuestion(Question _question, ExpressionValue _value) {
        Type type = _question.getType();
        this.questionLabel = _question.getLabel();

        IWidget widget = type.accept(this);
        widget.setWidgetValue(_value);
        widget.setReadOnly(true);
        return widget;
    }

    /**
     * TypeVisitor - Type To Widgets
     */
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
        throw new AssertionError();
    }
}