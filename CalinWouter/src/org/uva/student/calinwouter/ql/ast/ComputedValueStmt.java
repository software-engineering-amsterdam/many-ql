package org.uva.student.calinwouter.ql.ast;

public class ComputedValueStmt {
    private String ident, text;
    private Type type;
    private Exp exp;

    public ComputedValueStmt(String ident, String text, Type type, Exp exp) {
        this.ident = ident;
    }
}
