/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.qlqls.generated.node;

import org.uva.student.calinwouter.qlqls.generated.analysis.*;

@SuppressWarnings("nls")
public final class TTokenGreaterThanOrEquals extends Token
{
    public TTokenGreaterThanOrEquals()
    {
        super.setText(">=");
    }

    public TTokenGreaterThanOrEquals(int line, int pos)
    {
        super.setText(">=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTokenGreaterThanOrEquals(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTokenGreaterThanOrEquals(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTokenGreaterThanOrEquals text.");
    }
}
