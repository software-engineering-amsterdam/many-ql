package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.style_property.Width;

import java.util.ArrayList;
import java.util.List;

public class TextBox extends Widget {

    public final static int DEFAULT_WIDTH = 7;

    public TextBox(int _lineNum) {
        super(_lineNum);
    }

    public TextBox() {
    }

    @Override
    public void applyStyle(Style _style) {
        this.style = _style;
        // todo
    }

    @Override
    public Width getDefaultWidth() {
        return new Width(DEFAULT_WIDTH);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitTextBox(this);
    }
}