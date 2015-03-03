package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.style.Style;

public class NullWidget extends Widget {

    @Override
    public void applyStyle(Style _style) {
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
