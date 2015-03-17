package org.uva.student.calinwouter.qlqls.ql.model;

import java.util.LinkedList;
import java.util.List;

public class TypeCheckResults {
    private final List<String> errors, warnings;

    public void addError(final String s) {
        this.errors.add(s);
    }

    public void addWarning(final String s) {
        this.warnings.add(s);
    }

    public TypeCheckResults() {
        this.errors = new LinkedList<String>();
        this.warnings = new LinkedList<String>();
    }
}
