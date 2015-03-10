package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import java.util.ArrayList;
import java.util.List;

public class Dropdown extends Widget {

    private final String yesLabel;
    private final String noLabel;

    public Dropdown(int _lineNum, String _yes, String _no) {
        super(_lineNum);
        this.yesLabel = _yes;
        this.noLabel = _no;
    }

    public Dropdown(String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
    }

    @Override
    public void applyStyle(Style _style) {
        this.style = _style;
        // todo
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());
        supportedTypes.add(new IntType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitDropDown(this);
    }
}
