/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.qlqls.generated.node;

import org.uva.student.calinwouter.qlqls.generated.analysis.*;

@SuppressWarnings("nls")
public final class TTokenNotEquals extends Token
{
    public TTokenNotEquals()
    {
        super.setText("!=");
    }

    public TTokenNotEquals(int line, int pos)
    {
        super.setText("!=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTokenNotEquals(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTokenNotEquals(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTokenNotEquals text.");
    }
}
