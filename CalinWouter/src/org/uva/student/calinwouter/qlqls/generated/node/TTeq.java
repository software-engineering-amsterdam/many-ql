/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.qlqls.generated.node;

import org.uva.student.calinwouter.qlqls.generated.analysis.Analysis;

@SuppressWarnings("nls")
public final class TTeq extends Token {
    public TTeq() {
        super.setText("==");
    }

    public TTeq(int line, int pos) {
        super.setText("==");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone() {
        return new TTeq(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw) {
        ((Analysis) sw).caseTTeq(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text) {
        throw new RuntimeException("Cannot change TTeq text.");
    }
}
