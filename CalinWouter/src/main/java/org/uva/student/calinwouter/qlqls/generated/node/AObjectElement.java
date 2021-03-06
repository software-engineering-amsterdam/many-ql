/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.qlqls.generated.node;

import java.util.*;
import org.uva.student.calinwouter.qlqls.generated.analysis.*;

@SuppressWarnings("nls")
public final class AObjectElement extends PElement
{
    private final LinkedList<PKeyValue> _keyValue_ = new LinkedList<PKeyValue>();

    public AObjectElement()
    {
        // Constructor
    }

    public AObjectElement(
        @SuppressWarnings("hiding") List<?> _keyValue_)
    {
        // Constructor
        setKeyValue(_keyValue_);

    }

    @Override
    public Object clone()
    {
        return new AObjectElement(
            cloneList(this._keyValue_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAObjectElement(this);
    }

    public LinkedList<PKeyValue> getKeyValue()
    {
        return this._keyValue_;
    }

    public void setKeyValue(List<?> list)
    {
        for(PKeyValue e : this._keyValue_)
        {
            e.parent(null);
        }
        this._keyValue_.clear();

        for(Object obj_e : list)
        {
            PKeyValue e = (PKeyValue) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._keyValue_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._keyValue_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keyValue_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PKeyValue> i = this._keyValue_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PKeyValue) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
