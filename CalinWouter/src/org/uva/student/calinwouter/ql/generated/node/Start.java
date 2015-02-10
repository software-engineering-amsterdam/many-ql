/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.ql.generated.node;

import org.uva.student.calinwouter.ql.generated.analysis.*;

@SuppressWarnings("nls")
public final class Start extends Node
{
    private PBegin _pBegin_;
    private EOF _eof_;

    public Start()
    {
        // Empty body
    }

    public Start(
        @SuppressWarnings("hiding") PBegin _pBegin_,
        @SuppressWarnings("hiding") EOF _eof_)
    {
        setPBegin(_pBegin_);
        setEOF(_eof_);
    }

    @Override
    public Object clone()
    {
        return new Start(
            cloneNode(this._pBegin_),
            cloneNode(this._eof_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseStart(this);
    }

    public PBegin getPBegin()
    {
        return this._pBegin_;
    }

    public void setPBegin(PBegin node)
    {
        if(this._pBegin_ != null)
        {
            this._pBegin_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pBegin_ = node;
    }

    public EOF getEOF()
    {
        return this._eof_;
    }

    public void setEOF(EOF node)
    {
        if(this._eof_ != null)
        {
            this._eof_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eof_ = node;
    }

    @Override
    void removeChild(Node child)
    {
        if(this._pBegin_ == child)
        {
            this._pBegin_ = null;
            return;
        }

        if(this._eof_ == child)
        {
            this._eof_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(Node oldChild, Node newChild)
    {
        if(this._pBegin_ == oldChild)
        {
            setPBegin((PBegin) newChild);
            return;
        }

        if(this._eof_ == oldChild)
        {
            setEOF((EOF) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    public String toString()
    {
        return "" +
            toString(this._pBegin_) +
            toString(this._eof_);
    }
}