/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class THelpers extends Token {
    public THelpers() {
        super.setText("Helpers");
    }

    public THelpers(int line, int pos) {
        super.setText("Helpers");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone() {
        return new THelpers(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseTHelpers(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text) {
        throw new RuntimeException("Cannot change THelpers text.");
    }
}
