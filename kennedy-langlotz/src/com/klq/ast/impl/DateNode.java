package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

import java.time.LocalDate;

/**
 * Created by juriaan on 17-2-15.
 */
public class DateNode extends ANode {
    private LocalDate date;

    public DateNode(LocalDate date) {
        this.date = date;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public LocalDate getDate() {
        return date;
    }
}
