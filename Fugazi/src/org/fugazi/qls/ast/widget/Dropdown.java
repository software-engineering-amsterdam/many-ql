package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.style.Style;

public class Dropdown extends Widget {

    private final String yesLabel;
    private final String noLabel;

    public Dropdown(String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
    }

    @Override
    public void applyStyle(Style _style) {

    }
}
