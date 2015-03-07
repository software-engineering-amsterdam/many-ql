package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

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
        // todo
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitDropDown(this);
    }
}
