package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

import java.util.Date;

/**
 * Created by juriaan on 17-2-15.
 */
public class DateNode extends ANode {
    private Date date;

    public DateNode(Date date) {
        this.date = date;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public Date getDate() {
        return date;
    }
}
