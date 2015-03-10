package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import java.util.ArrayList;
import java.util.List;

public class SpinBox extends Widget {

    public SpinBox(int _lineNum) {
        super(_lineNum);
    }

    public SpinBox() {
    }

    @Override
    public void applyStyle(Style _style) {
        // todo
    }
    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new IntType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }


    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitSpinBox(this);
    }
}