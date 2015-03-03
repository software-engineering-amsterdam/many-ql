/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TQMark extends Token {
    public TQMark() {
        super.setText("?");
    }

    public TQMark(int line, int pos) {
        super.setText("?");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone() {
        return new TQMark(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseTQMark(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text) {
        throw new RuntimeException("Cannot change TQMark text.");
    }
}
